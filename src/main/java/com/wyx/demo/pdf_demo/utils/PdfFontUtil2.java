package com.wyx.demo.pdf_demo.utils;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;

import java.awt.*;
import java.io.*;
import java.security.*;

/**
 * @ClassName PdfFontUtil2
 * @Description 利用itextpdf2.1.7版本生成pdf
 * @Author yuxiang
 * @Date 2020/4/14
 * @Version 1.0
 **/
public class PdfFontUtil2 {
    // 字体
    private static BaseFont baseFont = null;

    static{
        try {
            /**
             * 设置字体
             *
             * windows路径字体
             * FONT_TYPE=C:/Windows/fonts/simsun.ttc
             * linux路径字体 宋体 (如果没有这个字体文件，就将windows的字体传上去)
             * FONT_TYPE=/usr/share/fonts/win/simsun.ttc
             */
            //可以用配置文件读取
            //获取配置
            //PropertiesLoader pl = new PropertiesLoader("/config/config.properties");
            //拼接文件web访问路径
            //String FONT_TYPE = pl.getProperty("FONT_TYPE");
            //解决中文问题  幼圆
            String path = "C:\\Windows\\Fonts\\simsun.ttc";//使用win字体 simsun.ttc
            path =  "/fonts/simsun.ttc";
            baseFont = BaseFont.createFont(path + ",1" , BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            baseFont = BaseFont.createFont("com/wyx/demo/pdf_demo/demo/simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文档超级  排版
     *
     * @param type 1-标题 2-标题一  3-标题二 4-标题三  5-正文  6-左对齐 7-右对齐
     */
    public static Paragraph getFont(int type, String text){
        Font font = new Font(baseFont);
        if(1 == type){//1-标题
            font.setSize(16f);
            font.setStyle(Font.BOLD);
        } else if(2 == type){//2-标题一
            font.setSize(16f);
            font.setStyle(Font.BOLD);
        } else if(3 == type){//3-标题二
            font.setSize(14f);
            font.setStyle(Font.BOLD);
        } else if(4 == type){//4-标题三
            font.setSize(14f);
        } else if(5 == type){//5-正文
//            font.setSize(10.5f);
            font.setSize(8f);
        } else if (6 == type) {//6-左对齐
            font.setSize(10.5f);
        } else if (7 == type) {//6-左对齐
            font.setSize(10.5f);
        } else {
            font.setSize(10.5f);//默认大小
        }
        //注： 字体必须和 文字一起new
        Paragraph paragraph = new Paragraph(text, font);
        if(1 == type){
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);//居中
            paragraph.setSpacingBefore(10f);//上间距
            paragraph.setSpacingAfter(10f);//下间距
        } else if(2 == type){//2-标题一
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED); //默认
            paragraph.setSpacingBefore(2f);//上间距
            paragraph.setSpacingAfter(2f);//下间距
        } else if(3 == type){
            paragraph.setSpacingBefore(2f);//上间距
            paragraph.setSpacingAfter(1f);//下间距
        } else if(4 == type){//4-标题三
            //paragraph.setAlignment(Element.ALIGN_RIGHT);//右对齐
            paragraph.setSpacingBefore(2f);//上间距
            paragraph.setSpacingAfter(2f);//下间距
        } else if(5 == type){
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            paragraph.setFirstLineIndent(24);//首行缩进
            paragraph.setSpacingBefore(1f);//上间距
            paragraph.setSpacingAfter(1f);//下间距
        } else if (6 == type) {//左对齐
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(1f);//上间距
            paragraph.setSpacingAfter(1f);//下间距
        } else if (7 == type) {//右对齐
            paragraph.setAlignment(Element.ALIGN_RIGHT);//右对齐
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            paragraph.setSpacingBefore(1f);//上间距
            paragraph.setSpacingAfter(1f);//下间距
        }
        //paragraph.setIndentationLeft(50);//整体缩进左边
        //paragraph.setFirstLineIndent(40);//首行缩进
        return paragraph;
    }

    /**
     * 创建一个pdf并打开
     * @param outpath  pdf路径
     */
    public static Document createPdf(String outpath) throws DocumentException, IOException {
        //页面大小
        //Rectangle rect = new Rectangle(PageSize.A4.rotate());//文档横方向
        Rectangle rect = new Rectangle(PageSize.A4);//文档竖方向
        //如果没有则创建
        File saveDir = new File(outpath);
        File dir = saveDir.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Document doc = new Document(rect);
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(outpath));
        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
        //使用自定义模板
        writer.setPageEvent(new PdfHeaderFooter());
        //文档属性
        //设置标题
        doc.addTitle("Title@wpixel");
        //设置作者
        doc.addAuthor("Author@wpixel");
        //设置主题
        doc.addSubject("Subject@wpixel");
        //设置关键字
        doc.addKeywords("Keywords@wpixel");
        //设置创建者
        doc.addCreator("Creator@wpixel");
        //设置创建日期
        doc.addCreationDate();
        // 设置生产者
        doc.addProducer();
        //页边空白
        doc.setMargins(20, 20, 20, 20);
        //打开文档
        // 设置用户密码, 所有者密码,用户权限,所有者权限
        //PdfWriter.ALLOW_MODIFY_CONTENTS
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.ALLOW_COPY
        //**允许复制，签名 不允许打印，编辑 加密级别：40-bit-RC ***
        //PdfWriter.ALLOW_MODIFY_ANNOTATIONS
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.ALLOW_FILL_IN
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.ALLOW_SCREENREADERS
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.ALLOW_ASSEMBLY
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.EMBEDDED_FILES_ONLY
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.DO_NOT_ENCRYPT_METADATA
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //PdfWriter.ENCRYPTION_AES_256
        //允许打印,编辑，复制，签名 加密级别：256-bit-AES
        //PdfWriter.ENCRYPTION_AES_128
        //允许打印,编辑，复制，签名 加密级别：128-bit-AES
        //PdfWriter.STANDARD_ENCRYPTION_128
        //允许打印,编辑，复制，签名 加密级别：128-bit-RC4
        //PdfWriter.STANDARD_ENCRYPTION_40
        //允许打印,编辑，复制，签名 加密级别：40-bit-RC4
        //原文链接：https://blog.csdn.net/tomatocc/article/details/80667838
//        writer.setEncryption("userpassword".getBytes(), "ownerPassword".getBytes(), PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
        doc.open();
//        // 加入水印
//        PdfContentByte waterMar = writer.getDirectContentUnder();
//        // 开始设置水印
//        waterMar.beginText();
//        // 设置水印透明度
//        PdfGState gs = new PdfGState();
//        // 设置填充字体不透明度为0.4f
//        gs.setFillOpacity(0.4f);
//        try {
//            String path = "C:\\Windows\\Fonts\\simsun.ttc";//使用win字体 simsun.ttc
//            path =  "/fonts/simsun.ttc";
//            baseFont = BaseFont.createFont(path + ",1" , BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            // 设置水印字体参数及大小                                  (字体参数，字体编码格式，是否将字体信息嵌入到pdf中（一般不需要嵌入），字体大小)
//            waterMar.setFontAndSize(baseFont, 60);
//            // 设置透明度
//            waterMar.setGState(gs);
//            // 设置水印对齐方式 水印内容 X坐标 Y坐标 旋转角度
//            waterMar.showTextAligned(Element.ALIGN_RIGHT, "一句话六六六" , 500, 430, 45);
//            // 设置水印颜色
//            waterMar.setColorFill(Color.GRAY);
//            //结束设置
//            waterMar.endText();
//            waterMar.stroke();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            waterMar = null;
//            gs = null;
//        }
//        try {
//            //图片水印
//            Image image = Image.getInstance("F:\\Ddemo\\itext\\123.jpg");
//            // 设置坐标 绝对位置 X Y
//            image.setAbsolutePosition(10, 100);
//            // 设置旋转弧度
//            image.setRotation(30);// 旋转 弧度
//            // 设置旋转角度
//            image.setRotationDegrees(45);// 旋转 角度
//            // 设置等比缩放
//            image.scalePercent(40);// 依照比例缩放
//            // image.scaleAbsolute(200,100);//自定义大小
//            // 设置透明度
//            waterMar.setGState(gs);
//            // 添加水印图片
//            waterMar.addImage(image);
//
//            //结束设置
//            waterMar.endText();
//            waterMar.stroke();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            waterMar = null;
//            gs = null;
//        }


        return doc;
    }

    //每个cell的格式，合并单元格情况
    public static PdfPCell getCell(Phrase phrase, boolean isborder, int colSpan, int rowSpan,int align) {
        PdfPCell cells = new PdfPCell(phrase);
        cells.setUseAscender(true);
        cells.setMinimumHeight(20f);
        cells.setHorizontalAlignment(align);
        cells.setVerticalAlignment(5);
        cells.setColspan(colSpan);
        cells.setRowspan(rowSpan);
        cells.setNoWrap(false);
        if (isborder) {
            cells.setBorder(Rectangle.NO_BORDER);
        }
        return cells;
    }

    //对pdf文档进行加密和权限设置 在179行实现
    /**
     *
     * @param src 需要签章的pdf文件路径
     * @param dest  签完章的pdf文件路径
     * @param p12Stream p12 路径
     * @param password
     * @param reason 签名的原因，显示在pdf签名属性中，随便填
     * @param location 签名的地点，显示在pdf签名属性中，随便填
     * @param chapterPath 签章图片路径
     */
//    public static void sign(InputStream src, OutputStream dest, InputStream p12Stream, char[]password, String reason, String location, String chapterPath){
//
//        try {
//            //读取keystore,获取私钥和证书链
//            KeyStore ks = KeyStore.getInstance("PKCS12");
//            ks.load(p12Stream, password);
//            String alias = (String) ks.aliases().nextElement();
//            PrivateKey pk = (PrivateKey) ks.getKey(alias, password);
//            Certificate[] chain = (Certificate[]) ks.getCertificateChain(alias);
//            // Creating the reader and the stamper，开始pdfreader
//            PdfReader reader = new PdfReader(src);
//            //创建签章工具，最后一个boolean参数
//            // false的话，pdf文件只允许被签名一次，多次签名，最后一次有效
//            // true的话，pdf可以被追加签名，验签工具可以识别出每次签名之后文档是否被修改
//            PdfStamper stamper = PdfStamper.createSignature(reader, dest, '\0', null, false);
//            // 获取数字签章属性对象，设定数字签章的属性
//            PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
//            appearance.setReason(reason);
//            appearance.setLocation(location);
//            //设置签名的位置，页码，签名域名称，多次追加签名的时候，签名预名称不能一样 图片大小受表单域大小影响（过小导致压缩）
//            //签名的位置，是图章相对于pdf页面的位置坐标，原点为pdf页面左下角
//            //四个参数的分别是，图章左下角x，图章左下角y，图章右上角x，图章右上角y
//            appearance.setVisibleSignature(new Rectangle(300, 600, 630, 500), 1, "sig1");
//            //读取图章图片，这个image是itext包的image
//            Image image = Image.getInstance(chapterPath);
//            appearance.setSignatureGraphic(image);
//            appearance.setCertificationLevel(PdfSignatureAppearance.CERTIFIED_NO_CHANGES_ALLOWED);
//
//            //设置图章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
////            appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
//            appearance.setRender(PdfSignatureAppearance.SignatureRenderNameAndDescription);
//
//            // 摘要算法
////            ExternalDigest digest = new BouncyCastleDigest();
////            // 签名算法
////            ExternalSignature signature = new PrivateKeySignature(pk, DigestAlgorithms.SHA256, null);
////            //  进行盖章操作 CMS高级电子签名(CAdES)的长效签名规范 调用itext签名方法完成pdf签章CryptoStandard.CMS 签名方式，建议采用这种
////            MakeSignature.signDetached(appearance, digest, signature, chain, null, null, null, 0, MakeSignature.CryptoStandard.CMS);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (UnrecoverableKeyException e) {
//            e.printStackTrace();
//        }   catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
