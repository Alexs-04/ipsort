from turtle import *

def draw_heart():
    bgcolor("black")
    color("red")
    title("JIJI")
    
    begin_fill()
    pensize(3)
    left(50)
    forward(133)
    circle(50,200)
    right(140)
    circle(50,200)
    forward(133)
    end_fill()


def text_heart(text):
    penup()
    goto(0, -50) 
    pendown()
    color("white")
    style = ('Courier' , 15 ,'bold')
    write(text, align="center", font= style)
    hideturtle()
    done()

draw_heart()
text_heart("Bañate, TQM!")
