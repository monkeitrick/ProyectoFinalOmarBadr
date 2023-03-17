$(".videoJuegoCarrusel").click(function () {
  $(".videoJuegoCarrusel").removeClass("active");
  $(this).addClass("active");
});

$(function () {
  $("div#btnMenu").click(function () {
    $("div#menu").addClass("open");
  });

  $("div#close").click(function () {
    $("div#menu").removeClass("open");
  });

  $("div#menu nav ul li").hover(
    function () {
      const index = $(this).index();
      $("div.background-image:eq(" + index + ")").fadeIn(500);
    },
    function () {
      const index = $(this).index();
      $("div.background-image:eq(" + index + ")").fadeOut(500);
    }
  );
});

/* Cookie */
let cookieName = "CodingStatus";
let cookieValue = "Coding Tutorials";
let cookieExpireDays = 30;
let acceptCookie = document.getElementById("acceptCookie");
acceptCookie.onclick = function () {
  createCookie(cookieName, cookieValue, cookieExpireDays);
};
let createCookie = function (cookieName, cookieValue, cookieExpireDays) {
  let currentDate = new Date();
  currentDate.setTime(
    currentDate.getTime() + cookieExpireDays * 24 * 60 * 60 * 1000
  );
  let expires = "expires=" + currentDate.toGMTString();
  document.cookie = cookieName + "=" + cookieValue + ";" + expires + ";path=/";
  if (document.cookie) {
    document.getElementById("cookiePopup").style.display = "none";
  } else {
    alert(
      "Unable to set cookie. Please allow all cookies site from cookie setting of your browser"
    );
  }
};
let getCookie = function (cookieName) {
  let name = cookieName + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(";");
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
};
let checkCookie = function () {
  let check = getCookie(cookieName);
  if (check == "") {
    document.getElementById("cookiePopup").style.display = "block";
  } else {
    document.getElementById("cookiePopup").style.display = "none";
  }
};
checkCookie();
