package com.wyx.demo.pdf_demo.demo;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.wyx.demo.pdf_demo.utils.PdfFontUtil2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ReportTest2
 * @Description 利用itext2.1.7版本生成pdf
 * @Author yuxiang
 * @Date 2020/4/14
 * @Version 1.0
 **/
public class ReportTest2 {
    public static void main(String[] args) {
        try {
            Document doc = PdfFontUtil2.createPdf("F:\\Ddemo\\itext\\test_report.pdf");
            //生成  合同文件
            createFile(doc);
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFile(Document doc) throws Exception {
        //页面大小
        doc.add(PdfFontUtil2.getFont(1, "数据分析报告"));
        PdfPTable tableBox = new PdfPTable(8);
        tableBox.setWidths(new float[]{0.2f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.1f, 0.1f});
        tableBox.setWidthPercentage(90f);
        //获取txt文本集合
        tableBox.setHeaderRows(2);
        // 创建表格格式及内容
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "分析结果")), false, 8, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Sample")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Raw_Reads")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Raw_Bases")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Valid_Reads")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Valid_Bases")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Valid%")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Q20%")), false, 1, 1, Element.ALIGN_CENTER));
        tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, "Q30%")), false, 1, 1, Element.ALIGN_CENTER));
        // 遍历查询出的结果

        PdfPTable tabletitle = new PdfPTable(2);
        tabletitle.setWidths(new float[]{0.5f, 0.5f});
        tabletitle.setWidthPercentage(90f);
        tabletitle.addCell(PdfFontUtil2.getCell(new Phrase((PdfFontUtil2.getFont(6, "名字：" + "张三"))), true, 1, 1, Element.ALIGN_LEFT));
        tabletitle.addCell(PdfFontUtil2.getCell(new Phrase((PdfFontUtil2.getFont(7, "年龄：" + "12"))), true, 1, 1, Element.ALIGN_RIGHT));
        // 设置页眉页脚
//        String var1 = "制表人:xxx" + "第： ";
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String var2 = " 页，打印日期" + sdf.format(d);
//        BaseFont baseFont = null;
//        String path = "C:\\Windows\\Fonts\\simsun.ttc";//使用win字体 simsun.ttc
//        path = "/fonts/simsun.ttc";
//        baseFont = BaseFont.createFont(path + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        Font f3 = new Font(baseFont);
//        HeaderFooter footer = new HeaderFooter(new Phrase(var1 + "", f3), new Phrase(var2 + "", f3));
//        footer.setBorder(Rectangle.NO_BORDER);
//        footer.setAlignment(Element.ALIGN_RIGHT);
//        doc.setFooter(footer);
        //获取txt文本集合
        List<Txt> txts = new ArrayList<Txt>() {{
            this.add(new Txt(1L, 1L, "PATH", "TXTpATH", "样本名1", 20000L, 18000L, 290139L));
            this.add(new Txt(2L, 2L, "PATH1", "TXTpATH1", "样本名2", 20000L, 18000L, 290139L));
            this.add(new Txt(3L, 3L, "PATH2", "TXTpATH2", "样本名3", 20000L, 18000L, 290139L));
        }};
//        for (Txt txt : txts) {
//            tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, txt.getSampleName())), false, 1, 1, Element.ALIGN_CENTER));
//            tableBox.addCell(PdfFontUtil2.getCell(new Phrase(String.valueOf(PdfFontUtil2.getFont(5, "" + txt.getAllReadsNum()))), false, 1, 1, Element.ALIGN_CENTER));
//            tableBox.addCell(PdfFontUtil2.getCell(new Phrase(String.valueOf(PdfFontUtil2.getFont(5, "" + txt.getMatchNum()))), false, 1, 1, Element.ALIGN_CENTER));
//        }
        //测试分页效果
        int s=1;
        for (int i = 1; i < 300000; i++) {
            for (Txt txt : txts) {
                tableBox.addCell(PdfFontUtil2.getCell(new Phrase(PdfFontUtil2.getFont(5, txt.getSampleName() + ">>>" + i)), false, 1, 1, Element.ALIGN_CENTER));
                tableBox.addCell(PdfFontUtil2.getCell(new Phrase(String.valueOf(PdfFontUtil2.getFont(5, "" + txt.getAllReadsNum()))), false, 1, 1, Element.ALIGN_CENTER));
                tableBox.addCell(PdfFontUtil2.getCell(new Phrase(String.valueOf(PdfFontUtil2.getFont(5, "" + txt.getMatchNum()))), false, 1, 1, Element.ALIGN_CENTER));
                tableBox.addCell(PdfFontUtil2.getCell(new Phrase(String.valueOf(PdfFontUtil2.getFont(5, "" + txt.getCreateTime()))), false, 1, 1, Element.ALIGN_CENTER));

            }
            if (i % 18== 0) {
                s++;
                doc.add(tabletitle);
                doc.add(tableBox);
                tableBox.deleteBodyRows();
                System.out.println("************"+i);
                System.out.println("第，，，"+s+"页");
                doc.newPage();
//                tableBox.setSkipFirstHeader(true);//防止释放后一页出现两次表头。
            }

        }
        //表格完成
//        doc.add(PdfFontUtil2.getFont(6, "参数说明："));
//        doc.add(PdfFontUtil2.getFont(6, "Sample：测序样本名"));
//        doc.add(PdfFontUtil2.getFont(6, "Sample：测序样本名"));
//        doc.add(PdfFontUtil2.getFont(6, "Sample：测序样本名"));
//        doc.add(PdfFontUtil2.getFont(6, "Sample：测序样本名"));
//        doc.add(PdfFontUtil2.getFont(6, "Sample：测序样本名"));
//        doc.add(PdfFontUtil2.getFont(6, "\n"));

    }
}
