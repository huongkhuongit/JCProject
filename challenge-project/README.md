# Challenge Project - Automation Testing với Appium, JUnit và Cucumber BDD

## Mô tả dự án
Dự án này là framework automation testing cho ứng dụng mobile Android sử dụng Appium cùng Java, tích hợp JUnit 4 làm test runner và Cucumber để hỗ trợ BDD (Behavior Driven Development).  
Mục tiêu của dự án là tự động hóa kiểm thử chức năng của app, với cấu trúc code rõ ràng, dễ bảo trì và mở rộng.

---

## Công nghệ sử dụng
- Java 17
- Appium Java Client 7.3.0
- JUnit 4
- Cucumber JVM (Cucumber-Java và Cucumber-JUnit)
- Maven (quản lý dependency và build)
- Allure Report (báo cáo test)
- Selenium WebDriver và WebDriverWait để tương tác UI
- AndroidDriver của Appium để điều khiển thiết bị Android
- Lombok để giảm boilerplate code (nếu sử dụng)

---

## Cấu trúc project
- `src/main/java/com/example/challengeproject/core`  
  Chứa các lớp Base, BaseTest, setup driver, quản lý wait và các hàm tiện ích dùng chung trong test.

- `src/main/java/com/example/challengeproject/PageObject`  
  Chứa các lớp Page Object đại diện cho các màn hình trong app (LoginPage, HomePage,...).

- `src/main/java/com/example/challengeproject/StepDefinitions`  
  Chứa các file Step Definition của Cucumber, mapping các bước kịch bản BDD với code test.

- `src/test/java/com/example/challengeproject/TestRunner`  
  Chứa các class runner để chạy test, ví dụ `RunAllTest.java` để chạy tất cả các scenario, hoặc chạy theo tag.

- `src/test/resources/features`  
  Chứa các file `.feature` định nghĩa các kịch bản BDD theo ngôn ngữ Gherkin.

- `src/main/java/com/example/challengeproject/Utils`  
  Các lớp tiện ích như AppiumDriverManager để khởi tạo driver.

---

## Hướng dẫn chạy project

### Yêu cầu môi trường
- Cài đặt JDK 17
- Cài đặt Maven
- Appium server đang chạy trên `http://localhost:4723`
- Thiết bị Android thật hoặc giả lập đang kết nối và sẵn sàng
- App được test đã được cài đặt hoặc có thể cài đặt thông qua Appium capability (hiện đang dùng package `com.axlehire.drive.staging`)

### Cách chạy test
#### Chạy bằng terminal
1. Mở terminal trong thư mục project.
2. Chạy lệnh để build và chạy toàn bộ test:
   ```bash
   mvn clean test
   ```
#### Chạy trực tiếp từ IDE (IntelliJ IDEA, Eclipse,...)

1. Đảm bảo sử dụng Java 17 làm SDK cho project và run configuration. 
2. Tạo hoặc chọn run configuration kiểu JUnit. 
3. Chọn class runner là: com.example.challengeproject.TestRunner.RunAllTest (hoặc runner khác nếu có).

4. Chạy run configuration này để thực thi toàn bộ test.

5. Nếu muốn chạy test theo tag @check, thì chọn file RunCheckTest