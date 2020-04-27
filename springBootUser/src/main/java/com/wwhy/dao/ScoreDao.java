package com.wwhy.dao;

import java.util.List;

import com.wwhy.entity.ScoreEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangpan
 * create date:2019-09-05
 */
@Repository
public interface ScoreDao{

	/**
	 * 添加所有
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public int insert(ScoreEntity entity);

	/**
	 * 添加非空字段
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public int insertSelective(ScoreEntity entity);

	/**
	 * 根据ID修改所有
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public int updateByPrimaryKey(ScoreEntity entity);

	/**
	 * 根据ID修改非空字段
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public int updateByPrimaryKeySelective(ScoreEntity entity);

	/**
	 * 根据ID删除数据
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public int deleteByPrimaryKey(Long id);

	/**
	 * 根据ID查询数据
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public ScoreEntity selectByPrimaryKey(Long id);

	/**
	 * 查询所有数据
	 * @author wangpan
	 * create date:2019-09-05
	 */
	public List<ScoreEntity> selectAll(ScoreEntity entity);

	/**
	 * 根据student ID计数
	 * @author eden
	 * create date:2019-09-05
	 */
	public int countByStudentId(Long studentId);

	/**
	 * 根据student ID删除数据
	 * @author eden
	 * create date:2019-09-05
	 */
	public int deleteScoreByStudentId(Long studentId);

	/**
	 * 根据studentID查询数据
	 * @author eden
	 * create date:2019-09-05
	 */
	public ScoreEntity selectByStudentId(Long studentId);

	/**
	 * 添加非空字段1-1-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int insertSelective1_1_1(ScoreEntity entity);

	/**
	 * 添加非空字段1-1-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int updateSelective1_1_1(ScoreEntity entity);

	/**
	 * 添加非空字段1-2-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int insertSelective1_2_1(ScoreEntity entity);

	/**
	 * 添加非空字段1-2-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int updateSelective1_2_1(ScoreEntity entity);

	/**
	 * 添加非空字段1-2-2
	 * @author eden
	 * create date:2019-09-05
	 */
	public int insertSelective1_2_2(ScoreEntity entity);

	/**
	 * 添加非空字段1-2-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int updateSelective1_2_2(ScoreEntity entity);

	/**
	 * 添加非空字段1-3-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int insertSelective1_3_1(ScoreEntity entity);

	/**
	 * 添加非空字段1-3-1
	 * @author eden
	 * create date:2019-09-05
	 */
	public int updateSelective1_3_1(ScoreEntity entity);

	/**
	 * 添加非空字段1-3-2
	 * @author eden
	 * create date:2019-09-05
	 */
	public int insertSelective1_3_2(ScoreEntity entity);

	/**
	 * 添加非空字段1-3-3
	 * @author eden
	 * create date:2019-09-05
	 */
	public int updateSelective1_3_2(ScoreEntity entity);
}