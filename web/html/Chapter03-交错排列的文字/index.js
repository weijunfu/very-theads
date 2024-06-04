
window.onload = () => {

const overlap = document.querySelector('.overlap')
const text = overlap.textContent
overlap.innerHTML = text.split('').map((e, i) => `<span style="z-index: ${text.length - i}">${e}</span>`).join('')

}
