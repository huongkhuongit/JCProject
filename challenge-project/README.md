
# JCProject (branch web-ui)

## Mô tả dự án
JCProject là dự án tự động hóa kiểm thử giao diện web sử dụng Java, Selenium WebDriver và JUnit 5.  
Mục tiêu của dự án là xây dựng framework kiểm thử tự động hiệu quả, dễ bảo trì, và mở rộng.

---

## Yêu cầu môi trường
- Java 17
- Maven 3.x trở lên
- Trình duyệt Chrome/Firefox (cài đặt tương ứng driver)
- IDE (IntelliJ IDEA, Eclipse, VS Code, ...)

---

## Cài đặt và chạy dự án

### 2. Build và chạy test bằng Maven (Terminal)
Mở terminal tại thư mục gốc của dự án, chạy lệnh sau để build và thực thi tất cả test case:
```bash
mvn clean test
```

### 3. Chạy test bằng IDE (IntelliJ IDEA, Eclipse)
- Mở dự án trong IDE.
- Đảm bảo cấu hình JDK version 17 cho project.
- Chạy từ các testcase bằng Junit như kiểu truyền thống
---

## Cấu trúc dự án
- `src/main/java/com/example/jcproject/`: Chứa mã nguồn chính của framework, bao gồm các lớp Base, Page Object, Utils, ...
- `src/test/java/com/example/jcproject/pages/`: Chứa các lớp Page Object đại diện cho các trang web cần test.
- `src/test/java/com/example/jcproject/testcases/`: Chứa các lớp Test Case sử dụng JUnit để viết các testcase.
- `src/test/java/com/example/jcproject/core/`: Chứa các lớp hỗ trợ chung cho framework như BaseTest, BasePage, cấu hình WebDriver,...
- `pom.xml`: File cấu hình Maven, quản lý dependencies và plugins.

---

## Công nghệ chính sử dụng
- Java 17
- Selenium WebDriver
- JUnit 5
- Maven
- (Nếu có) Cucumber cho BDD
- Các thư viện hỗ trợ như Lombok, Allure Reports...

---

## Các lưu ý khác
- Đảm bảo ChromeDriver (hoặc driver tương ứng) được đặt trong PATH hoặc cấu hình đúng trong code.
- Cấu hình timeout, địa chỉ server,... có thể tùy chỉnh trong file config hoặc code.
- Chạy test nên đảm bảo môi trường test ổn định (ví dụ: không bị popup hoặc thông báo gây ảnh hưởng đến test).
---