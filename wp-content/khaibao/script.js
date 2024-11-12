import { getNganhs, getTruongs, postURL } from "../../common/common.js";
// ============== Show list nganh =================

const datalistNganh = document.getElementById("options_manganh");

$(document).ready(function () {
  $.getJSON(getNganhs, function (data, textStatus, jqXHR) {
    $.each(data, function (indexInArray, valueOfElement) {
      const option = document.createElement("option");
      option.value = valueOfElement.manganh;
      option.textContent = valueOfElement.tennganh;
      datalistNganh.appendChild(option);
    });
  });
  // ============== End list nganh =================

  // ============== Show list truong =================

  const datalistTruong = document.getElementById("options_matruong");

  $.getJSON(getTruongs, function (data, textStatus, jqXHR) {
    $.each(data, function (indexInArray, valueOfElement) {
      const option = document.createElement("option");
      option.value = valueOfElement.matruong;
      option.textContent = valueOfElement.tentruong;
      datalistTruong.appendChild(option);
    });
  });

  // ============== End list truong =================

  //   jsonData.forEach((item) => {
  //     const option = document.createElement("option");
  //     option.value = item.manganh; // Gán mã ngành làm giá trị
  //     option.textContent = item.name; // Hiển thị tên ngành (tùy chọn)
  //     datalist.appendChild(option); // Thêm <option> vào <datalist>
  //   });

  //============= Phone ===============
  const sodt = document.getElementById("sodt");

  sodt.addEventListener("input", () => {
    let phone = sodt.value;
    let regex = /^(0|\+84)[0-9]{9}$/;

    if (!regex.test(phone)) {
      sodt.setCustomValidity("Số điện thoại không hợp lệ.");
    } else {
      sodt.setCustomValidity("");
    }
  });

  //============= Ngày tốt nghiệp ===============
  const ngaytn = document.getElementById("ngaytn");

  ngaytn.addEventListener("input", () => {
    let ngaynow = new Date();
    let _ngaytn = ngaytn.value;

    let diff = new Date(_ngaytn - ngaynow);
    let days = diff / 1000 / 60 / 60 / 24;

    // alert(days);

    // if (days <= 0) {
    //   ngaytn.setCustomValidity("Ngày không hợp lệ.");
    // } else {
    //   ngaytn.setCustomValidity("ssssssssssssss");
    // }
  });

  //   // ================= CCCD ==============
  //   const cccdInput = document.getElementById("user-cccd");

  //   cccdInput.addEventListener("input", () => {
  //     const cccd = cccdInput.value;
  //     const regex = /^(0)[0-9]{11}$/;

  //     if (!regex.test(cccd)) {
  //       cccdInput.setCustomValidity("Vui lòng nhập chính xác CCCD của bạn.");
  //     } else {
  //       cccdInput.setCustomValidity("");
  //     }
  //   });

  //   // ===============  password ======================
  //   const passwordInput = document.getElementById("user-password");

  //   passwordInput.addEventListener("input", () => {
  //     const password = passwordInput.value;
  //     const regex =
  //       /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,}$/;

  //     if (!regex.test(password)) {
  //       passwordInput.setCustomValidity(
  //         "Mật khẩu của bạn phải chứa ít nhất 6 kí tự\n ít nhất một chữ số \nmột chữ thường, một chữ hoa \n và một ký tự đặc biệt. "
  //       );
  //     } else {
  //       passwordInput.setCustomValidity("");
  //     }
  //   });

  $("#form_khaibao").submit(function (e) {
    e.preventDefault();
    const hoten = $("#hoten").val();
    const socmnd = $("#socmnd").val();
    const sodt = $("#sodt").val();
    const hetn = $("#hetn").val();
    const loaitn = $("#loaitn").val();
    const email = $("#email").val();
    const ngaytn = $("#ngaytn").val();
    const matruong = $("#matruong").val();
    const manganh = $("#manganh").val();
    const diachi = $("#diachi").val();

    $.ajax({
      url: postURL,
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify({
        socmnd,
        hoten,
        email,
        sodt,
        diachi,
        totNghieps: [
          {
            hetn,
            ngaytn,
            loaitn,
            matruong,
            manganh,
          },
        ],
      }),
      success: function (response) {
        console.log(response);
        alert("thành công!");
      },
      error: function (error) {
        alert("không thành công!");
      },
    });
  });
});
