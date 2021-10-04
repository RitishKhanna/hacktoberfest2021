import turtle
import math
import random
t = turtle.Turtle()
t.screen.bgcolor("black")
t.pensize(2)
t.color("brown")

t.penup()
t.left(90)
t.backward(250)
t.pendown()
t.speed(0)


def start(x):
    if x < 10:
        return
    else:
        t.forward(x)
        t.right(30)
        t.color("red")
        t.circle(2)
        start(x-10)
        t.color("yellow")
        t.left(60)
        t.color("green")
        start(x-10)
        t.color("white")
        t.right(30)
        t.backward(x)


start(100)

turtle.done()
