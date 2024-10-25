# Jaspersoft Studio报表开发



## 一、排版说明

+ `Title`：标题，仅在整个报表的第一页的顶端显示，其它页面不显示

+ `Page Header`：页头，在报表的每一页都显示。在第一页的`Title`下面展示，其它页面在顶端展示。

+ `Page Footer`：页脚，在报表的每一页底部展示。常用来展示页码。

+ `Detail 1`：报表内容，每一页都会展示。

+ `Column Header`：列头，若报表内容为表格，则列头就是表中列的列头。

+ `Column Footer`：列脚，若报表内容为表格，则列脚就是表中列的列脚。

+ `Summary`：统计，表格的合计段，一般出现在整个报表的最后一页中，主要用来做报表的合计显示。

  

  

  ## 二、参数说明



+ `$P{<param name>}`：参数
+ `$F{<column name>}`：字段
+ `$V{PAGE_NUMBER}`：页码
+ `$V{PAGE_COUNT}`：每页数据总条数
+ `$V{REPORT_COUNT}`：总数据条数



## 三、NULL值处理

`Properties -> Text Field -> Blank When NULL` 选中