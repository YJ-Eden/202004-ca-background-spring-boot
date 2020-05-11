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
	private String score111;

	@ApiModelProperty(value = "答案111",name="answer111")
	private String answer111;

	@ApiModelProperty(value = "更新时间12",name="updateTime12")
	private Date updateTime12;

	@ApiModelProperty(value = "是否完成12",name="iscomplete12")
	private Integer iscomplete12;

	@ApiModelProperty(value = "分数121",name="score121")
	private String score121;

	@ApiModelProperty(value = "答案121",name="answer121")
	private String answer121;

	@ApiModelProperty(value = "分数122",name="score122")
	private String score122;

	@ApiModelProperty(value = "答案122",name="answer122")
	private String answer122;

	@ApiModelProperty(value = "更新时间13",name="updateTime13")
	private Date updateTime13;

	@ApiModelProperty(value = "是否完成13",name="iscomplete13")
	private Integer iscomplete13;

	@ApiModelProperty(value = "分数131",name="score131")
	private String score131;

	@ApiModelProperty(value = "答案131",name="answer131")
	private String answer131;

	@ApiModelProperty(value = "分数132",name="score132")
	private String score132;

	@ApiModelProperty(value = "答案132",name="answer132")
	private String answer132;

	@ApiModelProperty(value = "更新时间21",name="updateTime11")
	private Date updateTime21;

	@ApiModelProperty(value = "是否完成21",name="iscomplete11")
	private Integer iscomplete21;

	@ApiModelProperty(value = "分数211",name="score111")
	private String score211;

	@ApiModelProperty(value = "答案211",name="answer111")
	private String answer211;

	@ApiModelProperty(value = "分数212",name="score111")
	private String score212;

	@ApiModelProperty(value = "答案212",name="answer111")
	private String answer212;

	@ApiModelProperty(value = "分数213",name="score111")
	private String score213;

	@ApiModelProperty(value = "答案213",name="answer111")
	private String answer213;

	@ApiModelProperty(value = "更新时间22",name="updateTime22")
	private Date updateTime22;

	@ApiModelProperty(value = "是否完成22",name="iscomplete22")
	private Integer iscomplete22;

	@ApiModelProperty(value = "分数223",name="score223")
	private String score223;

	@ApiModelProperty(value = "答案223",name="answer223")
	private String answer223;

	@ApiModelProperty(value = "更新时间23",name="updateTime23")
	private Date updateTime23;

	@ApiModelProperty(value = "是否完成23",name="iscomplete23")
	private Integer iscomplete23;

	@ApiModelProperty(value = "分数231",name="score231")
	private String score231;

	@ApiModelProperty(value = "答案231",name="answer231")
	private String answer231;

	@ApiModelProperty(value = "分数232",name="score232")
	private String score232;

	@ApiModelProperty(value = "答案232",name="answer232")
	private String answer232;

	@ApiModelProperty(value = "分数233",name="score233")
	private String score233;

	@ApiModelProperty(value = "答案233",name="answer233")
	private String answer233;

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

	public String getScore111(){
		return score111;
	}
	public void setScore111(String score){
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

	public String getScore121(){return score121;}
	public void setScore121(String score){this.score121 = score;}

	public String getAnswer121(){return answer121;}
	public void setAnswer121(String answer){answer121=answer;}

	public String getScore122(){return score122;}
	public void setScore122(String score){this.score122 = score;}

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

	public String getScore131(){return score131;}
	public void setScore131(String score){this.score131 = score;}

	public String getAnswer131(){return answer131;}
	public void setAnswer131(String answer){answer131=answer;}

	public String getScore132(){return score132;}
	public void setScore132(String score){this.score132 = score;}

	public String getAnswer132(){return answer132;}
	public void setAnswer132(String answer){answer132=answer;}

	public Date getUpdateTime21(){
		return updateTime21;
	}
	public void setUpdateTime21(Date updateTime){
		updateTime21 = updateTime;
	}

	public Integer getIscomplete21(){return iscomplete21;}
	public void setIscomplete21(Integer iscomplete){iscomplete21 = iscomplete;}

	public String getScore211(){
		return score211;
	}
	public void setScore211(String score){
		this.score211 = score;
	}

	public String getAnswer211(){return answer211;}
	public void setAnswer211(String answer){answer211=answer;}

	public String getScore212(){
		return score212;
	}
	public void setScore212(String score){
		this.score212 = score;
	}

	public String getAnswer212(){return answer212;}
	public void setAnswer212(String answer){answer212=answer;}

	public String getScore213(){
		return score213;
	}
	public void setScore213(String score){
		this.score213 = score;
	}

	public String getAnswer213(){return answer213;}
	public void setAnswer213(String answer){answer213=answer;}

	public Date getUpdateTime22(){
		return updateTime22;
	}
	public void setUpdateTime22(Date updateTime){
		updateTime22 = updateTime;
	}

	public Integer getIscomplete22(){return iscomplete22;}
	public void setIscomplete22(Integer iscomplete){iscomplete22 = iscomplete;}

	public String getScore223(){
		return score223;
	}
	public void setScore223(String score){
		this.score223 = score;
	}

	public String getAnswer223(){return answer223;}
	public void setAnswer223(String answer){answer223=answer;}

	public Date getUpdateTime23(){
		return updateTime23;
	}
	public void setUpdateTime23(Date updateTime){
		updateTime23 = updateTime;
	}

	public Integer getIscomplete23(){return iscomplete23;}
	public void setIscomplete23(Integer iscomplete){iscomplete23 = iscomplete;}

	public String getScore231(){
		return score231;
	}
	public void setScore231(String score){
		this.score231 = score;
	}

	public String getAnswer231(){return answer231;}
	public void setAnswer231(String answer){answer231=answer;}

	public String getScore232(){
		return score232;
	}
	public void setScore232(String score){
		this.score232 = score;
	}

	public String getAnswer232(){return answer232;}
	public void setAnswer232(String answer){answer232=answer;}

	public String getScore233(){
		return score233;
	}
	public void setScore233(String score){
		this.score233 = score;
	}

	public String getAnswer233(){return answer233;}
	public void setAnswer233(String answer){answer233=answer;}
}