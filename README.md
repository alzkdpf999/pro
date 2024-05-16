📦src<br/>
 ┣ 📂main<br/>
 ┃ ┣ 📂java<br/>
 ┃ ┃ ┗ 📂com<br/>
 ┃ ┃ ┃ ┗ 📂example<br/>
 ┃ ┃ ┃ ┃ ┗ 📂demo<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config (여기 부분은 kurento서버안열고 실행하면 에러나와서 나중에)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SslConfig.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebRtcConfig.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller (api명세서 관리)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileController.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MainController.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto (프론트와 오고가는 데이터)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FileDto.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity (디비 데이터 형식)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileEntity.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RoomEntity.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEntity.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRoomEntity.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂kurento (webrtc 부분)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CallHandler.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Room.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RoomManager.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRegistry.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserSession.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository (디비와 데이터 교환)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JpaUserRepository.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂service (비지니스 로직)<br/>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RoomService.java<br/>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BackendApplication.java<br/>
