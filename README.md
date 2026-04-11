d:\.vscode\spring-boot\demo/
├── src/
│   ├── main/                          ← Mã chính của ứng dụng
│   │   ├── java/com/example/demo/    ← Tất cả code Java
│   │   │   ├── DemoApplication.java          ← File khởi động ứng dụng
│   │   │   ├── controller/                  ← Tiếp nhận yêu cầu từ client
│   │   │   │   ├── ProductController.java   ← API cho sản phẩm
│   │   │   │   └── PlayerController.java    ← API cho người chơi
│   │   │   ├── service/                     ← Xử lý logic kinh doanh
│   │   │   │   ├── ProductService.java      ← Interface
│   │   │   │   └── impl/
│   │   │   │       └── ProductServiceImpl.java ← Cài đặt thực tế
│   │   │   ├── entity/                      ← Đại diện cho dữ liệu trong DB
│   │   │   │   ├── ProductEntity.java       ← Bảng sản phẩm
│   │   │   │   └── OrderEntity.java         ← Bảng đơn hàng
│   │   │   ├── repository/                  ← Truy cập dữ liệu từ DB
│   │   │   │   ├── ProductRepository.java   ← Interface
│   │   │   │   └── impl/
│   │   │   │       └── ProductRepositoryImpl.java ← Cài đặt
│   │   │   ├── dto/                         ← Đối tượng truyền dữ liệu
│   │   │   │   ├── request/                 ← Dữ liệu từ client gửi lên
│   │   │   │   │   └── product/
│   │   │   │   │       └── ProductCreateRequest.java
│   │   │   │   └── response/                ← Dữ liệu trả về cho client
│   │   │   │       └── product/
│   │   │   │           └── ProductResponseVO.java
│   │   │   ├── config/                      ← Cấu hình ứng dụng
│   │   │   ├── enums/                       ← Các hằng số, kiểu enum
│   │   │   └── base/                        ← Base class chung
│   │   └── resources/
│   │       ├── application.yaml             ← Cấu hình mặc định
│   │       ├── application-dev.yaml         ← Cấu hình môi trường phát triển
│   │       ├── application-pro.yaml         ← Cấu hình môi trường production
│   │       ├── application-test.yaml        ← Cấu hình môi trường test
│   │       ├── static/                      ← CSS, JS, hình ảnh tĩnh
│   │       └── templates/                   ← HTML templates (nếu dùng Thymeleaf)
│   └── test/                         ← Code test (JUnit, Mockito)
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java
├── pom.xml                           ← Cấu hình Maven, dependencies
├── mvnw, mvnw.cmd                   ← Maven wrapper (chạy Maven)
└── target/                           ← Thư mục build (JAR, class, log)



Client (Trình duyệt/Postman)
    ↓
Controller (nhận request)
    ↓
Service (xử lý logic)
    ↓
Repository (truy vấn DB)
    ↓
Entity (lấy/lưu dữ liệu)
    ↓
Response (trả dữ liệu về cho client)