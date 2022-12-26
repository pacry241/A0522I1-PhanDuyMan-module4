<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/26/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>Tờ Khai báo y tế</h3>

<form:form modelAttribute="medical" action="/add" method="post">
  <fieldset>
    <legend>Tờ khai ý tế</legend>
    <table>
      <tr>
        <td><form:label path="name">Họ tên (ghi chữ IN HOA):(*) </form:label></td>
        <td><form:input path="name"/></td>
      </tr>
      <tr>
        <td><form:label path="yearOfBirth">Năm Sinh </form:label></td>
        <td>
          <form:select  path="yearOfBirth">
            <form:option value="NONE"> --SELECT--</form:option>
            <c:forEach step="1" begin="1990" end="2023" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="gender">Giới Tính: </form:label></td>
        <td>
          <form:select  path="gender">
            <form:option value="NONE"> --SELECT--</form:option>
            <form:option value="Nam">Nam</form:option>
            <form:option value="Nu">Nu</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="nationality">Quốc Tịch:</form:label></td>
        <td>
          <form:select  path="nationality">
            <form:option value="NONE"> --SELECT--</form:option>
            <form:option value="VietNam">Việt Nam</form:option>
            <form:option value="ThaiLan">Thái Lan</form:option>
            <form:option value="US">US</form:option>
            <form:option value="Canada">Canada</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="passport">Hộ chiếu:(*) </form:label></td>
        <td><form:input path="passport"/></td>
      </tr>
      <tr>
        <td><form:label path="vehicle">Thông tin đi lại:(*) </form:label></td>
        <td><form:radiobuttons path="vehicle" items="${Vehicle}"/></td>
      </tr>
      <tr>
        <td><form:label path="number">Số hiệu phương tiện:(*) </form:label></td>
        <td><form:input path="number"/></td>
      </tr>
      <tr>
        <td><form:label path="seats">Số ghế:(*) </form:label></td>
        <td><form:input path="seats"/></td>
      </tr>
      <tr>
        <td><form:label path="departureDay">Ngày khởi hành (ngày):(*) </form:label></td>
        <td>
          <form:select  path="departureDay">
            <c:forEach step="1" begin="1" end="31" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="departureMonth">Tháng khởi hành (tháng):(*) </form:label></td>
        <td>
          <form:select  path="departureMonth">
            <c:forEach step="1" begin="1" end="12" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="departureYear">Năm khởi hành (năm):(*) </form:label></td>
        <td>
          <form:select  path="departureYear">
            <c:forEach step="1" begin="2015" end="2022" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="endDay">Ngày kết thúc (ngày):(*) </form:label></td>
        <td>
          <form:select  path="endDay">
            <c:forEach step="1" begin="1" end="31" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="endMonth">Tháng kết thúc (tháng):(*) </form:label></td>
        <td>
          <form:select  path="endMonth">
            <c:forEach step="1" begin="1" end="12" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="endYear">Năm kết thúc (năm):(*) </form:label></td>
        <td>
          <form:select  path="endYear">
            <c:forEach step="1" begin="2015" end="2022" var="item">
              <form:option value="${item}">${item}</form:option>
            </c:forEach>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="destination">Trong 14 ngày qua anh chị có đến thành phố nào khum:(*) </form:label></td>
        <td><form:textarea path="destination"/></td>
      </tr>
      <tr>
        <td colspan="2"><h1>Địa chỉ liên lạc</h1></td>
      </tr>
      <tr>

        <td><form:label path="conscious">Tỉnh/Thành:(*) </form:label></td>
        <td>
          <form:select  path="conscious">
            <form:option value="NONE"> --SELECT--</form:option>
            <form:option value="75">Huế</form:option>
            <form:option value="43">Đà Nẵng</form:option>
            <form:option value="74">Quảng Trị</form:option>
            <form:option value="95">Quảng Nam</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="district">Tỉnh/Thành:(*) </form:label></td>
        <td>
          <form:select  path="district">
            <form:option value="NONE"> --SELECT--</form:option>
            <form:option value="NguHanhSon">Ngũ Hành SƠn</form:option>
            <form:option value="HaiChau">Hải Châu</form:option>
            <form:option value="LienChieu">Liên Chiểu</form:option>
            <form:option value="SonTra">Sơn Trà</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="wards">Phường/Xã:(*) </form:label></td>
        <td>
          <form:select  path="wards">
            <form:option value="NONE"> --SELECT--</form:option>
            <form:option value="HoaHai">Hòa Hải</form:option>
            <form:option value="HoaQuy">Hòa Quý</form:option>
            <form:option value="XuanPhu">Xuân Phú</form:option>
            <form:option value="VyDa">Vỹ Dạ</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="address">Địa chỉ nơi ở:(*) </form:label></td>
        <td><form:input path="address"/></td>
      </tr>
      <tr>
        <td><form:label path="phone">Điện Thoại:(*) </form:label></td>
        <td><form:input path="phone"/></td>
      </tr>
      <tr>
        <td><form:label path="email">Email:(*) </form:label></td>
        <td><form:input path="email"/></td>
      </tr>
      <tr>
        <td colspan="2"><h1>Trong vòng 14 ngày qua anh chị có cảm thấy các trường hợp nào sau đây không</h1></td>
      </tr>
      <tr>

        <td><form:label path="fever">Sốt:(*) </form:label></td>
        <td>
          <form:radiobutton path="fever" value="true" label="Có"/>
          <form:radiobutton path="fever" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="cough">Ho:(*) </form:label></td>
        <td>
          <form:radiobutton path="cough" value="true" label="Có"/>
          <form:radiobutton path="cough" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="sultry">Khó thở:(*) </form:label></td>
        <td>
          <form:radiobutton path="sultry" value="true" label="Có"/>
          <form:radiobutton path="sultry" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="soreThroat">Đau họng:(*) </form:label></td>
        <td>
          <form:radiobutton path="soreThroat" value="true" label="Có"/>
          <form:radiobutton path="soreThroat" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="vomit">Nôn/ buồn nôn:(*) </form:label></td>
        <td>
          <form:radiobutton path="vomit" value="true" label="Có"/>
          <form:radiobutton path="vomit" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="diarrhea">Tiêu chảy:(*) </form:label></td>
        <td>
          <form:radiobutton path="diarrhea" value="true" label="Có"/>
          <form:radiobutton path="diarrhea" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="hemorrhage">Xuất huyết ngoài da:(*) </form:label></td>
        <td>
          <form:radiobutton path="hemorrhage" value="true" label="Có"/>
          <form:radiobutton path="hemorrhage" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="rash">Nổi ban ngoài da:(*) </form:label></td>
        <td>
          <form:radiobutton path="rash" value="true" label="Có"/>
          <form:radiobutton path="rash" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <h1>Lịch sử phơi nhiễm trong 14 ngày qua</h1>
        <td><form:label path="farm">Đến trang trại chăn nuôi/ chợ buôn bán
          động vật sống / cở sở mổ giết động vật/ tiếp xúc động vật:(*) </form:label></td>
        <td>
          <form:radiobutton path="farm" value="true" label="Có"/>
          <form:radiobutton path="farm" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:label path="contact">Tiếp xúc gần (<2m) với người mắc bệnh
          viêm đường hô hấp do nCoV (*)</form:label></td>
        <td>
          <form:radiobutton path="contact" value="true" label="Có"/>
          <form:radiobutton path="contact" value="false" label="Không"/>
        </td>
      </tr>
      <tr>
        <td><form:button>Cancel</form:button></td>
        <td><form:button>Add</form:button></td>
      </tr>
    </table>
  </fieldset>
</form:form>
</body>
</html>
