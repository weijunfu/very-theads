const swiper = new Swiper('.swiper', {
    // Optional parameters
    direction: 'horizontal',  // vertical垂直 horizontal水平
    loop: true,
    speed: 400,
    spaceBetween: 0,
    // slidesPerView: 3,
    autoplay: {
        delay: 500,
    },
    breakpoints: {
        '@0.75': {
            slidesPerView: 2,
            spaceBetween: 0,
        },
        '@1.00': {
            slidesPerView: 3,
            spaceBetween: 0,
        },
        '@1.50': {
            slidesPerView: 5,
            spaceBetween: 0,
        },
    },
    // If we need pagination
    pagination: {
      el: '.swiper-pagination',
    },
  
    // Navigation arrows
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  
    // And if we need scrollbar
    scrollbar: {
      el: '.swiper-scrollbar',
    },
  });