package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.FileDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/file")
public class FileController {
	@Value("${spring.servlet.multipart.location}") // location 안에 값이 들어감 EL사용
	private String location;

	@PostMapping("/upload")
	@ResponseBody
	public FileDto Upload(@RequestParam("file") MultipartFile file, @RequestParam("roomId") String roomId)
			throws Exception {
		String fileName = null;
		if (!file.isEmpty()) {
			fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
			file.transferTo(new File(fileName));
			log.info("파일 이름 : {}, 타입 : {}",fileName,file.getContentType());
		}
		// 나중에 db 이용이 필요함
		return new FileDto().builder().
				fileName(fileName).
				type(file.getContentType()).
				build();
	}

	@GetMapping("/download/{name}")
	@ResponseBody
	public ResponseEntity<Resource> Download(@PathVariable("name") String name) throws Exception {
		Path path = Paths.get(location + "/" + name);
		log.info("연결됨");
		String contentType = Files.probeContentType(path);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentDisposition(
				ContentDisposition.builder("attachment").filename(name, StandardCharsets.UTF_8).build());
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<Resource>(resource, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/{fileName}")
	@ResponseBody
	public ResponseEntity<Resource> imgFile(@PathVariable String fileName) throws IOException {
		log.info("이미지파일{}",fileName);
		Path path = Paths.get(location + "/" + fileName);
		// 만약 디비연결이면
		String contentType = Files.probeContentType(path);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new FileSystemResource(path);
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
}