# 🦁 TheZoo Management System 🐾

Hệ thống quản lý sở thú được viết bằng ngôn ngữ Java, áp dụng mô hình thiết kế **MVC (Model - View - Controller), kết hợp triệt để các nguyên lý **Lập trình hướng đối tượng (OOP), tính đa hình qua Interface, phân tách rõ ràng giữa xử lý logic, giao diện console và kiểm tra dữ liệu đầu vào.

---

## 🏗️ Cấu trúc mã nguồn

```text
02-TheZoo-Management/
│
├── controller/
│   └── TheZooManager.java         # Điều khiển logic CRUD, tìm kiếm & quản lý danh sách động vật
│
├── main/
│   └── Main.java                  # Điểm khởi chạy chương trình (Entry point)
│
├── model/
│   ├── Animal.java                # Lớp trừu tượng (Abstract Class) cơ sở cho mọi loài động vật
│   ├── Walkable.java              # Interface định nghĩa hành vi đi bộ
│   ├── Swimmable.java             # Interface định nghĩa hành vi bơi lội
│   ├── Flyable.java               # Interface định nghĩa hành vi bay
│   ├── WalkingAnimals.java        # Lớp con kế thừa Animal & implements Walkable (Động vật trên cạn)
│   ├── SwimmingAnimals.java       # Lớp con kế thừa Animal & implements Swimmable (Động vật dưới nước)
│   ├── FlyingAnimals.java         # Lớp con kế thừa Animal & implements Flyable (Động vật trên không)
│   ├── WalkFlyAnimals.java        # Lớp đa hình kết hợp cạn và không
│   ├── WalkSwimAnimals.java       # Lớp đa hình kết hợp cạn và nước
│   ├── FlySwimAnimals.java        # Lớp đa hình kết hợp không và nước
│   └── TriathlonAnimals.java      # Lớp đa hình toàn diện (cạn, không và nước)
│
├── utils/
│   ├── Utils.java                 # Các hàm tiện ích hỗ trợ đọc dữ liệu Console an toàn
│   └── Validates.java             # Kiểm tra định dạng đầu vào (Regex, khoảng giá trị, bắt lỗi)
│
└── view/
    ├── MenuView.java              # Hiển thị menu điều hướng (vòng lặp do-while)
    └── TheZooIOHandler.java       # Xử lý nhập/xuất, tạo đối tượng động vật theo Factory pattern
```

---

## 🧬 Các chủ điểm Lập trình Hướng đối tượng (OOP)

1. \*\*Tính Trừu tượng (Abstraction):

   - Lớp `Animal` được định nghĩa là `abstract` chứa các thuộc tính chung (`id`, `name`, `receivedDate`, `healthStatus`) và ép các lớp con phải tuân theo cấu trúc chuẩn.
   - Các hành vi vận động được bóc tách thành các Interface thuần túy: `Walkable`, `Swimmable`, `Flyable`.

2. \*\*Tính Kế thừa (Inheritance):

   - Các nhóm động vật (`WalkingAnimals`, `SwimmingAnimals`, `FlyingAnimals`,...) kế thừa trực tiếp từ lớp cha `Animal`, giúp tái sử dụng mã nguồn tối đa và tránh lặp code.

3. \*\*Tính Đa hình (Polymorphism):

   - Cho phép quản lý toàn bộ các loài động vật khác nhau thông qua một danh sách kiểu dữ liệu cha chung (`ArrayList<Animal>`).
   - Tận dụng các tổ hợp interface (`WalkSwimAnimals`, `TriathlonAnimals`,...) để một đối tượng có thể mang nhiều hình thái hành vi linh hoạt.

4. \*\*Tính Đóng gói (Encapsulation):
   - Toàn bộ các thuộc tính của lớp được đặt ở chế độ `private`, truy xuất và chỉnh sửa thông qua các phương thức `getter` / `setter` an toàn, kiểm soát chặt chẽ trạng thái đối tượng.

---

## 📌 Tính năng chính (v1.0)

- **Quản lý danh sách (CRUD):**
  - **Thêm mới:** Hỗ trợ tạo động vật phân loại theo 7 nhóm môi trường sống khác nhau.
  - **Hiển thị:** In toàn bộ danh sách động vật có trong sở thú kèm trạng thái.
  - **Cập nhật:** Sửa thông tin linh hoạt, hỗ trợ giữ nguyên giá trị cũ nếu bỏ trống (nhấn `Enter`).
  - **Xóa:** Loại bỏ động vật khỏi hệ thống dựa vào ID có kèm bước xác nhận an toàn `(Y/N)`.
- **Tìm kiếm thông minh:**
  - Hỗ trợ tìm kiếm theo tên (hoặc một phần ký tự bất kỳ) không phân biệt chữ hoa/thường (`substring matching`).
- **Kiểm tra dữ liệu đầu vào (Input Validation):**
  - Đảm bảo mã ID không bị trùng lặp trong hệ thống.
  - Ràng buộc định dạng ngày tháng tiếp nhận và chuỗi ký tự hợp lệ thông qua `Utils`.

---

## 🚀 Kế hoạch phát triển & Mở rộng (Roadmap)

- v1.1 - Nâng cấp bộ lọc:
  - Bổ sung sắp xếp danh sách động vật theo Tên (A-Z) hoặc theo Ngày tiếp nhận.
- v1.2 - Lưu trữ dữ liệu lâu dài (Persistence):
  - Tích hợp đọc/ghi file (`.txt` / `.json`) để lưu trạng thái sở thú khi tắt chương trình.
- v2.0 - Giao diện đồ họa (GUI):
  - Chuyển đổi từ giao diện Console sang ứng dụng desktop sử dụng JavaFX hoặc Swing.

---

## 📄 Giấy phép (License)

Dự án được xây dựng phục vụ mục đích học tập và thực hành chuyên sâu các kỹ thuật Lập trình hướng đối tượng (OOP) trong Java.
