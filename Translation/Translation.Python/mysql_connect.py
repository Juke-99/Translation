'''
Created on 2016/06/26

@author: yamanaka hikaru
'''

from jinja2 import Environment,FileSystemLoader
import codecs
import mysql.connector

connect = mysql.connector.connect(user='root', password='u', host='localhost', database='Translation', charset='utf8')
cursor = connect.cursor()
cursor.execute('select * from english where spell like "a%"')
rows = cursor.fetchall()

spell=[]
count=[]

for out1 in rows:
    dataset1=out1[0]
    spell.append(dataset1)

for out2 in rows:
    dataset2=out2[3]
    count.append(dataset2)

cursor.close()

env=Environment(loader=FileSystemLoader('../WebContent/JavaScript',encoding='utf8'))
temp1=env.get_template('./diagram.js')
html=temp1.render(data_list=count,data_spell=spell)

f=codecs.open('../WebContent/JavaScript/diagram1.js','w','utf8')
f.write(html)
f.close()