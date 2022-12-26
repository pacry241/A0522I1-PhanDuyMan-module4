<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/26/2022
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Complete</h1>
<h3>Họ tên: ${Medical.name}</h3>
<h3>Năm sinh: ${Medical.yearOfBirth}</h3>
<h3>Giới tính: ${Medical.gender}</h3>
<h3>Quốc tịch: ${Medical.nationality}</h3>
<h3>Số hộ chiếu: ${Medical.passport}</h3>
<h3>Thông tin đi lại: ${Medical.vehicle}</h3>
<h3>Số hiệu phương tiện: ${Medical.number}</h3>
<h3>Số ghế: ${Medical.seats}</h3>
<h3>Ngày khởi hành: ${Medical.departureDay}/${Medical.departureMonth}/${Medical.departureYear}</h3>
<h3>Ngày kết thúc: ${Medical.endDay}/${Medical.endMonth}/${Medical.endYear}</h3>
<h3>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh nào không: ${Medical.destination}</h3>
<h1>Địa chỉ liên lạc</h1>
<h3>Tỉnh / thành: ${Medical.conscious}</h3>
<h3>Quận / huyện: ${Medical.district}</h3>
<h3>Phường/ xã: ${Medical.wards}</h3>
<h3>Địa chỉ nơi ở: ${Medical.address}</h3>
<h3>Điện thoại: ${Medical.phone}</h3>
<h3>Email: ${Medical.email}</h3>
<h1>Trong vòng 14 ngày qua có triệu chứng gì không</h1>
<h3>Sốt: ${Medical.fever}</h3>
<h3>Ho: ${Medical.cough}</h3>
<h3>Sốt: ${Medical.fever}</h3>
<h3>Khó thở: ${Medical.sultry}</h3>
<h3>Đau họng: ${Medical.soreThroat}</h3>
<h3>Nôn/ buồn nôn: ${Medical.vomit}</h3>
<h3>Tiêu chảy: ${Medical.diarrhea}</h3>
<h3>Xuất huyết ngoài da: ${Medical.hemorrhage}</h3>
<h3>Nổi ban ngoài da: ${Medical.rash}</h3>
<h3>Đến trang trại chăn nuôi/ chợ buôn bán
    động vật sống / cở sở mổ giết động vật/ tiếp xúc động vật: ${Medical.farm}</h3>
<h3>Tiếp xúc gần (<2m) với người mắc bệnh
    viêm đường hô hấp do nCoV (*): ${Medical.contact}</h3>
</body>
</html>
