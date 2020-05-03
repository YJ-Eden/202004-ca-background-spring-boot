package com.wwhy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wwhy.entity.ScoreEntity;
import com.wwhy.vo.ScoreVO;

/**
 * @author wangpan
 * create date:2019-09-05
 */
public interface ScoreService{
	/**
	 * 添加
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public boolean insertScore(ScoreEntity entity);
	/**
	 * 修改
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public boolean updateScore(ScoreEntity entity);
	/**
	 * 根据ID删除
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public boolean deleteScoreById(Long id);
	/**
	 * 根据ID查询
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public ScoreVO getScoreById(Long id);
	/**
	 * 按条件获取全部
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public List<ScoreVO> getAllScoreListByCondition(ScoreEntity entityCondition);
	/**
	 * 按条件分页查询
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public PageInfo<ScoreVO> getPageScoreListByCondition(Integer pageStart, Integer pageSize, ScoreEntity entityCondition);
	/**
	 * 根据student ID查询
	 * @author eden
	 * create date:2019-09-05
	 */
	public int countScoreByStudentId(Long studentId);
	/**
	 * 根据student ID删除
	 * @author eden
	 * create date:2019-09-05
	 */
	public boolean deleteScoreByStudentId(Long studentId);
	/**
	 * 根据student ID查询
	 * @author eden
	 * create date:2019-09-05
	 */
	public ScoreVO getScoreByStudentId(Long studentId);

	/**
	 * 添加1-2-1
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore1_1_1(ScoreEntity entity);

	/**
	 * 添加1-2-1
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore1_2_1(ScoreEntity entity);

	/**
	 * 添加1-2-2
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore1_2_2(ScoreEntity entity);

	/**
	 * 添加1-3-1
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore1_3_1(ScoreEntity entity);

	/**
	 * 添加1-3-2
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore1_3_2(ScoreEntity entity);

	/**
	 * 添加2-1-1
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore2_1_1(ScoreEntity entity);

	/**
	 * 添加2-1-2
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore2_1_2(ScoreEntity entity);

	/**
	 * 添加2-1-3
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore2_1_3(ScoreEntity entity);

	/**
	 * 添加2-2-3
	 * @author eden
	 * create date:2020-03-26
	 */
	public boolean insertScore2_2_3(ScoreEntity entity);

}