package com.wwhy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.wwhy.common.util.DateUtil;
import com.wwhy.dao.BasicDataDao;
import com.wwhy.dao.ScoreDao;
import com.wwhy.dao.StudentDao;
import com.wwhy.dao.TeacherDao;
import com.wwhy.entity.BasicDataEntity;
import com.wwhy.entity.ScoreEntity;
import com.wwhy.entity.StudentEntity;
import com.wwhy.entity.TeacherEntity;
import com.wwhy.service.ScoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wwhy.vo.ScoreVO;
/**
 * @author wangpan
 * create date:2019-09-05
 */
@Transactional
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

	@Resource
	private ScoreDao scoreDao;

	@Resource
	private StudentDao studentDao;

	@Resource
	private TeacherDao teacherDao;

	@Resource
	private BasicDataDao basicDataDao;


	/**
	 * 修改
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@Override
	public boolean updateScore(ScoreEntity entity){
		boolean flag=false;
		int result = scoreDao.updateByPrimaryKeySelective(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 根据ID删除
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@Override
	public boolean deleteScoreById(Long id){
		boolean flag=false;
		int result = scoreDao.deleteByPrimaryKey(id);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 根据ID查询
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@Override
	@Transactional(readOnly=true)
	public ScoreVO getScoreById(Long id){
		ScoreVO vo=new ScoreVO();
		ScoreEntity entity = scoreDao.selectByPrimaryKey(id);
		if(entity != null){
			BeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}
	/**
	 * 获取全部
	 * @author wangpan
	 * @param entityCondition
	 * create date:2019-09-05
	 */
	@Override
	@Transactional(readOnly=true)
	public List<ScoreVO> getAllScoreListByCondition(ScoreEntity entityCondition){
		List<ScoreVO> vos = new ArrayList<ScoreVO>();
		List<ScoreEntity> list = scoreDao.selectAll(entityCondition);
		if(list!=null && list.size()>0){
			for(ScoreEntity entity:list){
				ScoreVO vo=new ScoreVO();
				BeanUtils.copyProperties(entity, vo);
				vos.add(vo);
			}
		}
		return vos;
	}
	/**
	 * 获取分页数据
	 * @author wangpan
	 * @param pageStart 开始页数
	 * @param pageSize 每页条数
	 * @param entityCondition
	 * create date:2019-09-05
	 */
	@Override
	@Transactional(readOnly=true)
	public PageInfo<ScoreVO> getPageScoreListByCondition(Integer pageStart,Integer pageSize,final ScoreEntity entityCondition){
		PageInfo<ScoreVO> pageVo=new PageInfo<ScoreVO>();
		PageInfo<ScoreEntity> pageInfo = PageHelper.startPage(pageStart, pageSize).doSelectPageInfo(new ISelect() {
			@Override
			public void doSelect() {
				scoreDao.selectAll(entityCondition);
			}
		});

		List<ScoreVO> vos=new ArrayList<ScoreVO>();
		for(ScoreEntity entity:pageInfo.getList()){
			ScoreVO vo=new ScoreVO();
			BeanUtils.copyProperties(entity, vo);

			StudentEntity studentEntity = studentDao.selectByPrimaryKey(entity.getStudentId());
			if(studentEntity != null){
				vo.setStudentName(studentEntity.getName());
			}
			TeacherEntity teacherEntity = teacherDao.selectByPrimaryKey(entity.getTeacherId());

			if(teacherEntity != null){
				vo.setTeacherName(teacherEntity.getName());
			}

			vo.setUpdateTimeStr(DateUtil.date2String(entity.getUpdateTime(),DateUtil.yyyy_MM_dd_HH_mm_ss));
			BasicDataEntity basicDataEntity = basicDataDao.selectBasicDataByTypeCode((short)1,entity.getProject().toString());
			if(basicDataEntity != null){
				vo.setProjectStr(basicDataEntity.getBasicName());
			}
			vos.add(vo);
		}

		pageVo.setList(vos);
		pageVo.setTotal(pageInfo.getTotal());
		return pageVo;
	}
	/**
	 * 根据student ID计数
	 * @author eden
	 * create date:2019-09-05
	 */
	public int countScoreByStudentId(Long studentId){
		ScoreVO vo=new ScoreVO();
		int n = scoreDao.countByStudentId(studentId);
		return n;
	}
	/**
	 * 根据student ID删除
	 * @author eden
	 * create date:2019-09-05
	 */
	@Override
	public boolean deleteScoreByStudentId(Long studentId){
		boolean flag=false;
		int result = scoreDao.deleteScoreByStudentId(studentId);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 添加
	 * @author eden
	 * create date:2020-03-19
	 */
	@Override
	public boolean insertScore(ScoreEntity entity){
		boolean flag=false;
		int result = scoreDao.insertSelective(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 根据student ID查询
	 * @author eden
	 * create date:2019-09-05
	 */
	@Override
	@Transactional(readOnly=true)
	public ScoreVO getScoreByStudentId(Long StudentId){
		ScoreVO vo=new ScoreVO();
		ScoreEntity entity = scoreDao.selectByStudentId(StudentId);
		if(entity != null){
			BeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}

	/**
	 * 添加1-1-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore1_1_1(ScoreEntity entity){
		boolean flag=false;
		int result;
		double score = 0;
		double times;
		String scoreS;
		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
			ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
			if(entitySql.getScore111()!=null) times = Double.parseDouble(entitySql.getScore111().split("\\^")[1])+1;
			else times = 1;
		}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setIscomplete11(1);
		entity.setScore111(scoreS);

		if(n>=1) result = scoreDao.updateSelective1_1_1(entity);
		else result = scoreDao.insertSelective1_1_1(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加1-2-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore1_2_1(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//12个
		Double[] answer121 = {12.0,6.0,0.0,0.866,-0.5,0.0,0.5,0.866,0.0,0.0,0.0,1.0};
		String[] answers121 = entity.getAnswer121().split("\\^");
		for(int i = 0;i<12;i++){
			if(answer121[i].equals(Double.parseDouble(answers121[i])))score++;
		}
//		for(int i = 0;i < 3;i++){
//			if(answer1211[i].equals(entity.getAnswer121()[i]))score++;
//		}
//		Double answer1212[] = {0.866,-0.5,0.0,0.5,0.866,0.0,0.0,0.0,1.0};
//		for(int i = 0;i<9;i++){
//			if(answer1212[i].equals(entity.getAnswerarray1212()[i]))score++;
//		}
		int n=scoreDao.countByStudentId(entity.getStudentId());
		if(n>=1){
		ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
		if(entitySql.getScore121()!=null) times = Double.parseDouble(entitySql.getScore121().split("\\^")[1])+1;
		else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore121(scoreS);
		//Double anserarray121[]={1.0,2.0,5.1};
		//entity.setAnswerarray121(anserarray121);


		int result;
		if(n>=1) result = scoreDao.updateSelective1_2_1(entity);
		else result = scoreDao.insertSelective1_2_1(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加1-2-2
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore1_2_2(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//3个
		Double answer122[] = {11.098,13.562,0.0};
		String[] answers122 = entity.getAnswer122().split("\\^");
		for(int i = 0;i<3;i++){
			if(answer122[i].equals(Double.parseDouble(answers122[i])))score++;
		}

//		for(int i = 0;i < 3;i++){
//			if(answer1221[i].equals(entity.getAnswerarray1221()[i]))score++;
//		}

		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
		ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
		if(entitySql.getScore122()!=null) times = Double.parseDouble(entitySql.getScore122().split("\\^")[1])+1;
		else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore122(scoreS);
		entity.setIscomplete12(1);
		//Double anserarray121[]={1.0,2.0,5.1};
		//entity.setAnswerarray121(anserarray121);


		int result;
		if(n>=1) result = scoreDao.updateSelective1_2_2(entity);
		else result = scoreDao.insertSelective1_2_2(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加1-3-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore1_3_1(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//36个
		Double[] answer131 = {1.0,0.0,0.0,3.0,0.0,1.0,0.0,2.0,0.0,0.0,1.0,1.0,
				0.71,-0.71,0.0,6.0,0.71,0.71,0.0,0.0,0.0,0.0,1.0,0.0,
				0.0,-1.0,0.0,8.0,1.0,0.0,0.0,3.54,0.0,0.0,1.0,0.0};
		String[] answers131 = entity.getAnswer131().split("\\^");
		for(int i = 0;i<36;i++){
			if(answer131[i].equals(Double.parseDouble(answers131[i])))score++;
		}

		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
		ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
		if(entitySql.getScore131()!=null) times = Double.parseDouble(entitySql.getScore131().split("\\^")[1])+1;
		else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore131(scoreS);


		int result;
		if(n>=1) result = scoreDao.updateSelective1_3_1(entity);
		else result = scoreDao.insertSelective1_3_1(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加1-3-2
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore1_3_2(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//16个
		Double answer1321[] = {0.71,0.71,0.0,0.71,-0.71,0.71,0.0,4.95,0.0,0.0,1.0,1.0,0.0,0.0,0.0,1.0};
		Double answer1322[] = {0.71,0.71,0.0,-1.24,-0.71,0.71,0.0,8.24,0.0,0.0,1.0,1.0,0.0,0.0,0.0,1.0};
		String[] answers132 = entity.getAnswer132().split("\\^");
		for(int i = 0;i<4;i++){
			if(Double.parseDouble(answers132[i])==0.0)score++;
		}
		score++;
		if(Double.parseDouble(answers132[4])==0.0){
			for(int i = 0;i<16;i++){
				if(answer1321[i].equals(Double.parseDouble(answers132[i+5])))score++;
			}
		}
		else{
			for(int i = 0;i<16;i++){
				if(answer1322[i].equals(Double.parseDouble(answers132[i+5])))score++;
			}
		}

		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
		ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
		if(entitySql.getScore132()!=null) times = Double.parseDouble(entitySql.getScore132().split("\\^")[1])+1;
		else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore132(scoreS);
		entity.setIscomplete13(1);
		//Double anserarray121[]={1.0,2.0,5.1};
		//entity.setAnswerarray121(anserarray121);


		int result;
		if(n>=1) result = scoreDao.updateSelective1_3_2(entity);
		else result = scoreDao.insertSelective1_3_2(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加2-1-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore2_1_1(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//2个
		Double[] answer211 = {1.0,2.0};
		String[] answers211 = entity.getAnswer211().split("\\^");
		for(int i = 0;i<2;i++){
			if(answer211[i].equals(Double.parseDouble(answers211[i])))score++;
		}

		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
			ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
			if(entitySql.getScore211()!=null) times = Double.parseDouble(entitySql.getScore211().split("\\^")[1])+1;
			else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore211(scoreS);


		int result;
		if(n>=1) result = scoreDao.updateSelective2_1_1(entity);
		else result = scoreDao.insertSelective2_1_1(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加2-1-2
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore2_1_2(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//10个
		Double[] answer212 = {1.0,2.0,0.0,1.0,0.0,0.0,1.0,1.0,1.0,1.0};
		String[] answers212 = entity.getAnswer212().split("\\^");
		for(int i = 0;i<10;i++){
			if(answer212[i].equals(Double.parseDouble(answers212[i])))score++;
		}

		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
			ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
			if(entitySql.getScore212()!=null) times = Double.parseDouble(entitySql.getScore212().split("\\^")[1])+1;
			else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore212(scoreS);


		int result;
		if(n>=1) result = scoreDao.updateSelective2_1_2(entity);
		else result = scoreDao.insertSelective2_1_2(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加2-1-3
	 * @author eden
	 * create date:2020-03-26
	 */
	@Override
	public boolean insertScore2_1_3(ScoreEntity entity){
		boolean flag=false;
		double score=0;
		double times;
		String scoreS;
		//6个
		Double[] answer213 = {1.0,2.0,2.0,1.0,2.0,1.0};
		String[] answers213 = entity.getAnswer213().split("\\^");
		for(int i = 0;i<6;i++){
			if(answer213[i].equals(Double.parseDouble(answers213[i])))score++;
		}

		int n=scoreDao.countByStudentId(entity.getStudentId());

		if(n>=1){
			ScoreEntity entitySql = scoreDao.selectByStudentId(entity.getStudentId());
			if(entitySql.getScore213()!=null) times = Double.parseDouble(entitySql.getScore213().split("\\^")[1])+1;
			else times = 1;}
		else times = 1;
		scoreS = String.valueOf(score) + "^" + String.valueOf(times);

		entity.setScore213(scoreS);
		entity.setIscomplete21(1);

		int result;
		if(n>=1) result = scoreDao.updateSelective2_1_3(entity);
		else result = scoreDao.insertSelective2_1_3(entity);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
}