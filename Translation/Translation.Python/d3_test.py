'''
Created on 2016/06/26

@author: yamanaka hikaru
'''

from jinja2 import Environment,FileSystemLoader
import numpy as np
import codecs

env=Environment(loader=FileSystemLoader('../WebContent/JavaScript',encoding='utf8'))
temp1=env.get_template('./d3_test.js')
html=temp1.render(data_list="[12,32,12,42,12,42,53,14,23,12,43]")

f=codecs.open('../WebContent/JavaScript/d3_test2.js','w','utf8')
f.write(html)
f.close()