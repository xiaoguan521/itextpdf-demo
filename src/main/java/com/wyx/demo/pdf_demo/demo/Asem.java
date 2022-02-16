package com.wyx.demo.pdf_demo.demo;

/**
 * Author xiaochen
 * Date 2022-02-16 - 9:29
 * Description TODO
 */
class Asem {

    private Long id;

    /**
     * task表的主键
     */
    private Long taskId;

    /**
     * 数据路径
     */
    private String sequencerPath;

    /**
     * 文件路径
     */
    private String txtPath;

    /**
     * 样本名称
     */
    private String sampleName;

    /**
     * 基因组覆盖度
     */
    private String genomeCoverage;
    /**
     * 拼接的序列长度
     */
    private String sequenceLength;

    /**
     * 基因相似度
     */
    private String geneSimilarity;

    /**
     * 文件名1-B01-20200207.B01.clean.virus.final.fa
     */
    private String asemFaName;

    /**
     * 目标final.fa转成json格式数据
     */
    private String asemFaJson;

    /**
     * 创建时间
     */
    private Long createTime;

    public Asem() {
    }

    public Asem(Long id, Long taskId, String sequencerPath, String txtPath, String sampleName, String genomeCoverage, String sequenceLength, String geneSimilarity, String asemFaName, String asemFaJson, Long createTime) {
        this.id = id;
        this.taskId = taskId;
        this.sequencerPath = sequencerPath;
        this.txtPath = txtPath;
        this.sampleName = sampleName;
        this.genomeCoverage = genomeCoverage;
        this.sequenceLength = sequenceLength;
        this.geneSimilarity = geneSimilarity;
        this.asemFaName = asemFaName;
        this.asemFaJson = asemFaJson;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getSequencerPath() {
        return sequencerPath;
    }

    public void setSequencerPath(String sequencerPath) {
        this.sequencerPath = sequencerPath;
    }

    public String getTxtPath() {
        return txtPath;
    }

    public void setTxtPath(String txtPath) {
        this.txtPath = txtPath;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getGenomeCoverage() {
        return genomeCoverage;
    }

    public void setGenomeCoverage(String genomeCoverage) {
        this.genomeCoverage = genomeCoverage;
    }

    public String getSequenceLength() {
        return sequenceLength;
    }

    public void setSequenceLength(String sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    public String getGeneSimilarity() {
        return geneSimilarity;
    }

    public void setGeneSimilarity(String geneSimilarity) {
        this.geneSimilarity = geneSimilarity;
    }

    public String getAsemFaName() {
        return asemFaName;
    }

    public void setAsemFaName(String asemFaName) {
        this.asemFaName = asemFaName;
    }

    public String getAsemFaJson() {
        return asemFaJson;
    }

    public void setAsemFaJson(String asemFaJson) {
        this.asemFaJson = asemFaJson;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
