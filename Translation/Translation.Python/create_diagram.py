'''
Created on 2016/06/25

@author: yamanaka hikaru
'''

from jinja2 import Environment,FileSystemLoader

env=Environment(loader=FileSystemLoader('./',encoding='UTF8'))
tmp1=env.get_template('./diagram.tmp1')
html=tmp1.render(name1="IVE",name2="EVA")

print(html)