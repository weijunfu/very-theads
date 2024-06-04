console.log('js')


let rad = 0

window.onload = function() {
    const pointer = document.querySelector('.pointer')

    window.onmousemove = function(e) {
        const { clientX, clientY, movementX, movementY } = e

        if(Math.abs(movementX) + Math.abs(movementY) < 3) return

        const rad = Math.atan2(movementX, -movementY)

        pointer.style.transform = `translate(${clientX}px, ${clientY}px) rotate(${rad}rad)`
    };
};