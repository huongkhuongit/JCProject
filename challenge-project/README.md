
# JCProject (branch api-test)

## Mô tả dự án
JCProject là dự án tự động hóa kiểm thử API sử dụng Java, RestAssured và JUnit 5.  
Mục tiêu của dự án là xây dựng framework kiểm thử API hiệu quả, dễ bảo trì, có cấu trúc rõ ràng và dễ mở rộng.

---

## Yêu cầu môi trường
- Java 17
- Maven 3.x trở lên
- IDE (IntelliJ IDEA, Eclipse, VS Code, ...)
- Máy có kết nối mạng để tải dependencies Maven

---

## Cài đặt và chạy dự án

### 1. Clone repo và checkout branch `api-test`
```bash
git clone https://github.com/huongkhuongit/JCProject.git
cd JCProject
git checkout api-test
```

### 2. Build và chạy test bằng Maven (Terminal)
Mở terminal tại thư mục gốc của dự án, chạy lệnh sau để build và thực thi tất cả test case:
```bash
mvn clean test
```

### 3. Chạy test bằng IDE (IntelliJ IDEA, Eclipse)
- Mở dự án trong IDE.
- Đảm bảo cấu hình JDK version 17 cho project.
- Chạy từ các class test trong thư mục `src/test/java` bằng JUnit.
---

## Cấu trúc dự án
- `src/main/java/com/example/jcproject/`: Chứa mã nguồn chính của framework, bao gồm các lớp hỗ trợ, Utils, cấu hình.
- `src/test/java/com/example/jcproject/testcases/`: Chứa các lớp test case kiểm thử API sử dụng JUnit 5 và RestAssured.
- `src/test/java/com/example/jcproject/core/`: Chứa các lớp BaseTest, BaseAPI,... dùng chung cho các test case.
- `pom.xml`: File cấu hình Maven, quản lý dependencies và plugins.

---

## Công nghệ chính sử dụng
- Java 17
- RestAssured
- JUnit 5
- Maven

---