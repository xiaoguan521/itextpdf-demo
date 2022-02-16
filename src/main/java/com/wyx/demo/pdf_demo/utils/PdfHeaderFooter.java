package com.wyx.demo.pdf_demo.utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author xiaochen
 * Date 2022-02-16 - 10:41
 * Description TODO
 */
public class PdfHeaderFooter extends PdfPageEventHelper {
    String header;
    int presentFontSize =12;
    PdfTemplate total;
    BaseFont bf =null;
    Font fontDetail =null;

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        Rectangle pageSize = writer.getBoxSize("art");
        try {
            if (bf == null) {
                String path =  "/fonts/simsun.ttc";
                bf = BaseFont.createFont(path + ",1" , BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            }
            if (fontDetail == null) {
                fontDetail = new Font(bf, presentFontSize, Font.NORMAL);// 资料体字型
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int pageN = writer.getPageNumber();
        String nstr = "刘晓晨";//后期进行设计处理
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tstr = sdf.format(d);
        String text1 = "制表人:" + nstr;
        String text2 = "制表时间:" + tstr;
        String text3 = "第" + pageN + "页/共";
        PdfPTable table = new PdfPTable(4);
        try {
            table.setWidths(new int[]{
                2, 2, 1, 1
            });
            table.setWidthPercentage(90F);//占据百分百宽度
            table.setTotalWidth(500F);
            PdfPCell cell1 = new PdfPCell(new Phrase(text1, fontDetail));
            PdfPCell cell2 = new PdfPCell(new Phrase(text2, fontDetail));
            PdfPCell cell3 = new PdfPCell(new Phrase(text3, fontDetail));
            PdfPCell cell4 = new PdfPCell(Image.getInstance(total));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setBorder(Rectangle.NO_BORDER);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell3.setBorder(Rectangle.NO_BORDER);
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell4.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.writeSelectedRows(0, -1, document.left(), document.bottom(), writer.getDirectContent());
        } catch (DocumentException de) {
            throw new ExceptionConverter (de);
        }
    }

    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        try {
            if (bf == null) {
                String path =  "/fonts/simsun.ttc";
                bf =BaseFont.createFont(path + ",1" , BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);;//隶书
            }
            if (fontDetail == null) {
                fontDetail = new Font(bf, presentFontSize, Font.NORMAL);// 资料体字型
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.format("%d页", writer.getPageNumber() - 1), fontDetail), 2, 2, 0);
    }

}
