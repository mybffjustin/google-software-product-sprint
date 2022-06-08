// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random about to the page.
 */
function addRandomAbout() {
    const abouts =
        ['Student 👨‍🎓', 'Software Engineer 👨‍💻', 'Web Software Developer 👨‍💻'];

    // Pick a random about.
    const about = abouts[Math.floor(Math.random() * abouts.length)];

    // Add it to the page.
    const aboutContainer = document.getElementById('about-container');
    aboutContainer.innerText = about;
}

/** Fetches the string from the server and adds it to the page. */
async function showHelloResp() {
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();

    const helloContainer = document.getElementById('hello-container');
    helloContainer.innerText = textFromResponse;
}

/**
 * Scroll to the top of the document
 */

configObj = {
    "buttonD": "M8 18.568L10.8 21.333 16 16.198 21.2 21.333 24 18.568 16 10.667z",
    "buttonT": "translate(-1148 -172) translate(832 140) translate(32 32) translate(284)",
    "shadowSize": "none",
    "roundnessSize": "12px",
    "buttonDToBottom": "32px",
    "buttonDToRight": "32px",
    "selectedBackgroundColor": "#ff0000",
    "selectedIconColor": "#ffffff",
    "buttonWidth": "40px",
    "buttonHeight": "40px",
    "svgWidth": "32px",
    "svgHeight": "32px"
};

function createButton(obj, pageSimulator) {
    const body = document.querySelector("body");
    backToTopButton = document.createElement("span");
    backToTopButton.classList.add("softr-back-to-top-button");
    backToTopButton.id = "softr-back-to-top-button";
    pageSimulator ? pageSimulator.appendChild(backToTopButton) : body.appendChild(backToTopButton);
    backToTopButton.style.width = obj.buttonWidth;
    backToTopButton.style.height = obj.buttonHeight;
    backToTopButton.style.marginRight = obj.buttonDToRight;
    backToTopButton.style.marginBottom = obj.buttonDToBottom;
    backToTopButton.style.borderRadius = obj.roundnessSize;
    backToTopButton.style.boxShadow = obj.shadowSize;
    backToTopButton.style.color = obj.selectedBackgroundColor;
    backToTopButton.style.backgroundColor = obj.selectedBackgroundColor;
    pageSimulator ? backToTopButton.style.position = "absolute" : backToTopButton.style.position = "fixed";
    backToTopButton.style.outline = "none";
    backToTopButton.style.bottom = "0px";
    backToTopButton.style.right = "0px";
    backToTopButton.style.cursor = "pointer";
    backToTopButton.style.textAlign = "center";
    backToTopButton.style.border = "solid 2px currentColor";
    backToTopButton.innerHTML = '<svg class="back-to-top-button-svg" xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32" > <g fill="none" fill-rule="evenodd"> <path d="M0 0H32V32H0z" transform="translate(-1028 -172) translate(832 140) translate(32 32) translate(164) matrix(1 0 0 -1 0 32)" /> <path class="back-to-top-button-img" fill-rule="nonzero" d="M11.384 13.333h9.232c.638 0 .958.68.505 1.079l-4.613 4.07c-.28.246-.736.246-1.016 0l-4.613-4.07c-.453-.399-.133-1.079.505-1.079z" transform="translate(-1028 -172) translate(832 140) translate(32 32) translate(164) matrix(1 0 0 -1 0 32)" /> </g> </svg>';
    backToTopButtonSvg = document.querySelector(".back-to-top-button-svg");
    backToTopButtonSvg.style.verticalAlign = "middle";
    backToTopButtonSvg.style.margin = "auto";
    backToTopButtonSvg.style.justifyContent = "center";
    backToTopButtonSvg.style.width = obj.svgWidth;
    backToTopButtonSvg.style.height = obj.svgHeight;
    backToTopButton.appendChild(backToTopButtonSvg);
    backToTopButtonImg = document.querySelector(".back-to-top-button-img");
    backToTopButtonImg.style.fill = obj.selectedIconColor;
    backToTopButtonSvg.appendChild(backToTopButtonImg);
    backToTopButtonImg.setAttribute("d", obj.buttonD);
    backToTopButtonImg.setAttribute("transform", obj.buttonT);
    if (!pageSimulator) {
        backToTopButton.style.display = "none";
        window.onscroll = function () {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                backToTopButton.style.display = "block";
            } else {
                backToTopButton.style.display = "none";
            }
        };
        backToTopButton.onclick = function () {
            document.body.scrollTop = 0;
            document.documentElement.scrollTop = 0;
        };
    }
};
document.addEventListener("DOMContentLoaded", function () {
    createButton(configObj, null);
});
/******************************************************************************************************************************
 Waypoints
 *******************************************************************************************************************************/

$(document).ready(function () {

    $('.wp1').waypoint(function () {
        $('.wp1').addClass('animated fadeInLeft');
    }, {
        offset: '75%'
    });
    $('.wp2').waypoint(function () {
        $('.wp2').addClass('animated fadeInUp');
    }, {
        offset: '75%'
    });
    $('.wp3').waypoint(function () {
        $('.wp3').addClass('animated fadeInDown');
    }, {
        offset: '55%'
    });
    $('.wp4').waypoint(function () {
        $('.wp4').addClass('animated fadeInDown');
    }, {
        offset: '75%'
    });
    $('.wp5').waypoint(function () {
        $('.wp5').addClass('animated fadeInUp');
    }, {
        offset: '75%'
    });
    $('.wp6').waypoint(function () {
        $('.wp6').addClass('animated fadeInDown');
    }, {
        offset: '75%'
    });

});

/******************************************************************************************************************************
 Nav Button
 *******************************************************************************************************************************/

$(window).load(function () {

    $('.nav_slide_button').click(function () {
        $('.pull').slideToggle();
    });

});


$(function () {

    $('a[href*=#]:not([href=#])').click(function () {
        if (location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '') && location.hostname === this.hostname) {

            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: target.offset().top - 125
                }, 1000);
                return false;
            }
        }
    });

});

/******************************************************************************************************************************
 Nav Transform
 *******************************************************************************************************************************/

document.querySelector("#nav-toggle").addEventListener("click", function () {
    this.classList.toggle("active");
});

/******************************************************************************************************************************
 Flexsliders
 *******************************************************************************************************************************/

$(window).load(function () {

    $('#blogSlider').flexslider({
        animation: "slide",
        directionNav: false,
        controlNav: true,
        touch: false,
        pauseOnHover: true,
        start: function () {
            $.waypoints('refresh');
        }
    });

    $('#servicesSlider').flexslider({
        animation: "slide",
        directionNav: false,
        controlNav: true,
        touch: true,
        pauseOnHover: true,
        start: function () {
            $.waypoints('refresh');
        }
    });

    $('#teamSlider').flexslider({
        animation: "slide",
        directionNav: false,
        controlNav: true,
        touch: true,
        pauseOnHover: true,
        start: function () {
            $.waypoints('refresh');
        }
    });

    $('#clientSlider').flexslider({
        animation: "slide",
        directionNav: false,
        controlNav: true,
        touch: true,
        pauseOnHover: true,
        start: function () {
            $.waypoints('refresh');
        }
    });

});

