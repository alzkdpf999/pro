📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config (여기 부분은 kurento서버안열고 실행하면 에러나와서 나중에)
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SslConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebRtcConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller (api명세서 관리)
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MainController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto (프론트와 오고가는 데이터)
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FileDto.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity (디비 데이터 형식)
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RoomEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRoomEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂kurento (webrtc 부분)
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CallHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Room.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RoomManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRegistry.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserSession.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository (디비와 데이터 교환)
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JpaUserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂service (비지니스 로직)
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RoomService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BackendApplication.java
