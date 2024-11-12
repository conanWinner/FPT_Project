import { searchSinhvien, searchVieclam } from "../../common/common.js";
$(document).ready(function () {
  $("#btn_search_sinhvien").click(function (e) {
    e.preventDefault();

    const value = $("#input_search_sinhvien").val();

    console.log(value);

    $.ajax({
      type: "POST",
      url: searchSinhvien,
      contentType: "application/json",
      data: JSON.stringify(value),
      success: function (response) {
        $.each(response, function (indexInArray, value) {
          console.log(value);

          let content = `
                      <div class="qh_c">
                            <div style="word-wrap: break-word;">${value.socmnd}</div>
                            <div style="word-wrap: break-word;">${value.hoten}</div>
                            <div style="word-wrap: break-word;">${value.email}</div>
                            <div style="word-wrap: break-word;">${value.sodt}</div>
                            <div style="word-wrap: break-word;">${value.diachi}</div>
                      </div>

          `;

          $("div.abody").append(content);
        });
      },
      error: function (error) {
        alert("không thành công!");
      },
    });
  });
});

$(document).ready(function () {
  $("#btn_search_vieclam").click(function (e) {
    e.preventDefault();

    const value = $("#input_search_vieclam").val();

    console.log(value);

    $.ajax({
      type: "POST",
      url: searchVieclam,
      contentType: "application/json",
      data: JSON.stringify(value),
      success: function (response) {
        $.each(response, function (indexInArray, value) {
          console.log(value);

          let content = `
                      <div class="qh_c">

                            <div style="word-wrap: break-word;">${value.socmnd}</div>
                            <div style="word-wrap: break-word;">${value.hoten}</div>
                            <div style="word-wrap: break-word;">${value.manganh}</div>
                            <div style="word-wrap: break-word;">${value.matruong}</div>
                            <div style="word-wrap: break-word;">${value.tencongty}</div>
                            <div style="word-wrap: break-word;">${value.thoigianlamviec}</div>

                      </div>

          `;

          $("div.abody").append(content);
        });
      },
      error: function (error) {
        alert("không thành công!");
      },
    });
  });
});
