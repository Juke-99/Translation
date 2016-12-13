'''
Created on 2016/06/25

@author: yamanaka hikaru
'''

from jinja2 import Environment,FileSystemLoader
import codecs

env=Environment(loader=FileSystemLoader('../WebContent',encoding='utf8'))
tmp1=env.get_template('./test_js.html')
html=tmp1.render(message_1=u"jinja2から",message_2=u"文字私完了！")

f=codecs.open('../WebContent/test_js_output.html','w','utf8')
f.write(html)
f.close()