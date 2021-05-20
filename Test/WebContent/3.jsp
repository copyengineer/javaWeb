<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        input,textarea,select{
            outline: 0;
        }
        .content {
            width: 600px;
            border: 5px solid pink;
            margin: 0 auto;
            padding-left: 20px;
        }

        hr {
            margin: 20px 0px;
            size: 1px;
        }

        textarea {
            width: 500px;
            height: 200px;
            font-family: Arial, Helvetica, sans-serif;
            padding: 10px;
            color: #666;
        }

        h1 {
            margin: 20px;
            text-align: center;
            size: 1px;
        }

        input[type=text] {
            width: 300px;
        }

        input[type=submit] {
            margin: 5px auto;
        }
        .content{
            padding: 1px;
        }
        #button_g{
            height: 31px;
            text-align:center;
            line-height: 31px;
        }
        #button_g input{
            width: 100px;
            border: none;
            background-color: pink;
            color: black;
        }
    </style>
</head>
<body>

    <form  action="target_servlet" class="content" method="post">
        <h1>图书馆读者调查问卷</h1>
        <hr color= pink>
        &nbsp;&nbsp;&nbsp;&nbsp;为了能够及时了解您对图书馆的需求，提升我校图书馆文献资源建设的质量和水平，更好的为我校教学科研服务，我馆特设计了问卷调查题目如下，请协助填写，谢谢您的合作！
        <hr color= pink>
        &nbsp;&nbsp;&nbsp;1.你的年级<br>
        请你选择&nbsp;&nbsp;<select name="grade">
        <option value="default">请选择你的年级</option>
        <option value="2018">2018</option>
        <option value="2019">2019</option>
    </select>

        <hr color= pink>
        &nbsp;&nbsp;&nbsp;2.您的专业<br>
        <input type="text" name="pro">
        <hr>
        &nbsp;&nbsp;&nbsp;3.您对图书馆的阅览环境<br>
        <input type="radio" name="comment" value="满意">满意<br>
        <input type="radio" name="comment" value="基本满意">基本满意<br>
        <input type="radio" name="comment" value="不满意">不满意&nbsp;&nbsp;&nbsp;您的建议&nbsp;&nbsp;&nbsp;<input type="text" name="dis_advice"><br>
        <hr>
        &nbsp;&nbsp;&nbsp;4.您到图书馆学习的原因(可多选)<br>

        <input type="checkbox" name="result" value="借阅专业图书">借阅专业图书<br>
        <input type="checkbox" name="result" value="随便坐坐">随便坐坐<br>
        <input type="checkbox" name="result" value="借阅光盘">借阅光盘<br>
        <input type="checkbox" name="result" value="参加图书馆组织的活动">参加图书馆组织的活动<br>
        <input type="checkbox" name="result" value="自习，复习功课">自习，复习功课<br>
        <input type="checkbox" name="result" value="上网">上网<br>
        <input type="checkbox" name="result"  value="检索电子文献">检索电子文献<br>

        <hr>
        &nbsp;&nbsp;&nbsp;5.您到圖書館的频率：<br>

        <input type="radio" name="frequency" value="几乎每天都去">几乎每天都去<br>
        <input type="radio" name="frequency" value="每周1-2次">每周1-2次<br>
        <input type="radio" name="frequency" value="每月1-2次">每月1-2次<br>
        <input type="radio" name="frequency" value="几乎不去">几乎不去<br>

        <hr>
        &nbsp;&nbsp;&nbsp;6.您对学校的意见：<br>
        <textarea id="content" placeholder="请输入您的建议：" name="sch_advice"></textarea>
        <hr>
        <div id="button_g">
            <input type="submit" value="提交答案" >
            <input type="reset" name="clear" value="清空" onclick="reset()" >
        </div>
    </form>

</body>
</html>
