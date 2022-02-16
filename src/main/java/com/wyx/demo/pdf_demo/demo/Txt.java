package com.wyx.demo.pdf_demo.demo;

/**
 * Author xiaochen
 * Date 2022-02-16 - 9:29
 * Description TODO
 */
class Txt {
    /**
     * 主键
     */
    private Long id;

    /**
     * 主键
     */
    private Long taskId;

    /**
     * 路径
     */
    private String sequencerPath;

    /**
     * txt文本路径
     */
    private String txtPath;

    /**
     * 样本名称
     */
    private String sampleName;

    /**
     * 总reads数量
     */
    private Long allReadsNum;

    /**
     * 匹配到基因组的数量
     */
    private Long matchNum;

    /**
     * 创建时间
     */
    private Long createTime;

    public Txt() {
    }

    public Txt(Long id, Long taskId, String sequencerPath, String txtPath, String sampleName, Long allReadsNum, Long matchNum, Long createTime) {
        this.id = id;
        this.taskId = taskId;
        this.sequencerPath = sequencerPath;
        this.txtPath = txtPath;
        this.sampleName = sampleName;
        this.allReadsNum = allReadsNum;
        this.matchNum = matchNum;
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

    public Long getAllReadsNum() {
        return allReadsNum;
    }

    public void setAllReadsNum(Long allReadsNum) {
        this.allReadsNum = allReadsNum;
    }

    public Long getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(Long matchNum) {
        this.matchNum = matchNum;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }


}
