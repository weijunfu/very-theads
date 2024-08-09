
const counterList = document.querySelectorAll('.counter')

function counter(element) {
    if(!element) return

    const targetValue = parseInt(element.dataset.count)
    let firstChild = element.querySelector('span:nth-child(1)')
    let currentValue = parseInt(firstChild.textContent, 10)

    let startTime = performance.now();
  
    function updateNumber(timestamp) {
      const progress = timestamp - startTime;
      const duration = 1000; // 动画持续时间，单位毫秒
      const value = Math.min(targetValue, currentValue + (targetValue - currentValue) * progress / duration);
  
      firstChild.textContent = value.toFixed(0); // 更新元素内容
  
      if (progress < duration) {
        requestAnimationFrame(updateNumber);
      }
    }
  
    requestAnimationFrame(updateNumber);
}


function observeElement(element) {
    const observer = new IntersectionObserver((entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
            counter(element)
        } else {
            let numEle = element.querySelector('span:nth-child(1)')
            numEle.innerText = 0
        }
      });
    });
  
    observer.observe(element);
  }
  
for(let node of counterList) {
    // console.log(node)
    observeElement(node)
}
