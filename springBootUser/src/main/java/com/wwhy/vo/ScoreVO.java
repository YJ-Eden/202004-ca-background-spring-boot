package com.wwhy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
* @author wangpan
* create date:2019-09-05
*/
@ApiModel(value="")
public class ScoreVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id",name="id")
	private Long id;

	@ApiModelProperty(value = "学生id",name="studentId")
	private Long studentId;

	@ApiModelProperty(value = "学生姓名",name="studentName")
	private String studentName;

	@ApiModelProperty(value = "教学科目（对应基础数据表type=1）",name="project")
	private Byte project;

	@ApiModelProperty(value = "教学科目（对应基础数据表type=1）",name="projectStr")
	private String projectStr;

	@ApiModelProperty(value = "成绩单位",name="unit")
	private String unit;

	@ApiModelProperty(value = "分数",name="score")
	private Double score;

	@ApiModelProperty(value = "排名",name="ranking")
	private Short ranking;

	@ApiModelProperty(value = "教师id",name="teacherId")
	private Long teacherId;

	@ApiModelProperty(value = "教师姓名",name="teacherName")
	private String teacherName;

	@ApiModelProperty(value = "更新时间",name="updateTime")
	private Date updateTime;

	@ApiModelProperty(value = "更新时间",name="updateTimeStr")
	private String updateTimeStr;

	@ApiModelProperty(value = "备注",name="remark")
	private String remark;

	@ApiModelProperty(value = "更新时间11",name="updateTime11")
	private Date updateTime11;

	@ApiModelProperty(value = "是否完成11",name="iscomplete11")
	private Integer iscomplete11;

	@ApiModelProperty(value = "分数111",name="score111")
	private Double score111;

	@ApiModelProperty(value = "答案111",name="answer111")
	private String answer111;

	@ApiModelProperty(value = "更新时间12",name="updateTime12")
	private Date updateTime12;

	@ApiModelProperty(value = "是否完成12",name="iscomplete12")
	private Integer iscomplete12;

	@ApiModelProperty(value = "分数121",name="score121")
	private Double score121;

	@ApiModelProperty(value = "答案121",name="answer121")
	private String answer121;

	@ApiModelProperty(value = "分数122",name="score122")
	private Double score122;

	@ApiModelProperty(value = "答案122",name="answer122")
	private String answer122;

	@ApiModelProperty(value = "更新时间13",name="updateTime13")
	private Date updateTime13;

	@ApiModelProperty(value = "是否完成13",name="iscomplete13")
	private Integer iscomplete13;

	@ApiModelProperty(value = "分数131",name="score131")
	private Double score131;

	@ApiModelProperty(value = "答案131",name="answer131")
	private String answer131;

	@ApiModelProperty(value = "分数132",name="score132")
	private Double score132;

	@ApiModelProperty(value = "答案132",name="answer132")
	private String answer132;


	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getStudentId(){
		return studentId;
	}

	public void setStudentId(Long studentId){
		this.studentId = studentId;
	}

	public Byte getProject(){
		return project;
	}

	public void setProject(Byte project){
		this.project = project;
	}

	public Double getScore(){
		return score;
	}

	public void setScore(Double score){
		this.score = score;
	}

	public Short getRanking(){
		return ranking;
	}

	public void setRanking(Short ranking){
		this.ranking = ranking;
	}

	public Long getTeacherId(){
		return teacherId;
	}

	public void setTeacherId(Long teacherId){
		this.teacherId = teacherId;
	}

	public Date getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}

	public String getRemark(){
		return remark;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getProjectStr() {
		return projectStr;
	}

	public void setProjectStr(String projectStr) {
		this.projectStr = projectStr;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getUpdateTime11(){
		return updateTime11;
	}
	public void setUpdateTime11(Date updateTime){
		updateTime11 = updateTime;
	}

	public Integer getIscomplete11(){return iscomplete11;}
	public void setIscomplete11(Integer iscomplete){iscomplete11 = iscomplete;}

	public Double getScore111(){
		return score111;
	}
	public void setScore111(Double score){
		this.score111 = score;
	}

	public String getAnswer111(){return answer111;}
	public void setAnswer111(String answer){answer111=answer;}

	public Date getUpdateTime12(){
		return updateTime12;
	}
	public void setUpdateTime12(Date updateTime){
		updateTime12 = updateTime;
	}

	public Integer getIscomplete12(){return iscomplete12;}
	public void setIscomplete12(Integer iscomplete){iscomplete12 = iscomplete;}

	public Double getScore121(){return score121;}
	public void setScore121(Double score){this.score121 = score;}

	public String getAnswer121(){return answer121;}
	public void setAnswer121(String answer){answer121=answer;}

	public Double getScore122(){return score122;}
	public void setScore122(Double score){this.score122 = score;}

	public String getAnswer122(){return answer122;}
	public void setAnswer122(String answer){answer122=answer;}

	public Date getUpdateTime13(){
		return updateTime13;
	}
	public void setUpdateTime13(Date updateTime){
		updateTime13 = updateTime;
	}

	public Integer getIscomplete13(){return iscomplete13;}
	public void setIscomplete13(Integer iscomplete){iscomplete13 = iscomplete;}

	public Double getScore131(){return score131;}
	public void setScore131(Double score){this.score131 = score;}

	public String getAnswer131(){return answer131;}
	public void setAnswer131(String answer){answer131=answer;}

	public Double getScore132(){return score132;}
	public void setScore132(Double score){this.score132 = score;}

	public String getAnswer132(){return answer132;}
	public void setAnswer132(String answer){answer132=answer;}
}