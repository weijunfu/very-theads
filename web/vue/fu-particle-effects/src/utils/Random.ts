
export const randomNumber = (min:number, max:number):number => Math.random()*(max-min+1) + min
export const randomInteger = (min:number, max:number):number => Math.floor(randomNumber(min, max))

export const randomColor = ():number => Math.floor(Math.random() * 256)

export const randomRgba = () => 'rgba('+Math.floor(Math.random()*256)+', '+Math.floor(Math.random()*256)+','+ Math.floor(Math.random()*256)+','+ Math.random()+')' 

