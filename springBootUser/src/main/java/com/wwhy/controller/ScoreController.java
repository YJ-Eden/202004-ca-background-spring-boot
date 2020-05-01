package com.wwhy.controller;

import com.wwhy.entity.ScoreEntity;
import com.wwhy.service.RedisService;
import com.wwhy.service.ScoreService;
import com.wwhy.vo.StudentVO;
import com.wwhy.vo.TeacherVO;
import io.swagger.annotations.*;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.wwhy.common.result.CommResult;
import com.wwhy.common.result.HttpResult;
import com.wwhy.vo.ScoreVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangpan
 * create date:2019-09-05
 */
@Api(value = "API - ScoreController", description = "成绩接口说明")
@ResponseBody
@Controller
@RequestMapping("score")
public class ScoreController{

	@Resource
	private ScoreService scoreService;

	@Resource
	private RedisService redisService;

	/**
	 * 添加
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@ApiOperation(value="添加", response=CommResult.class)
	@PostMapping(value = "insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult insertScore(HttpServletRequest request, ScoreEntity entity){
		TeacherVO teacher = (TeacherVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime(new Date());
		entity.setTeacherId(teacher.getId());
		boolean flag = scoreService.insertScore(entity);
		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");
	}
	/**
	 * 修改
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@ApiOperation(value="修改", response=CommResult.class)
	@PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult updateScore(HttpServletRequest request,ScoreEntity entity){
		TeacherVO teacher = (TeacherVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime(new Date());
		entity.setTeacherId(teacher.getId());
		boolean flag = scoreService.updateScore(entity);
		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("修改失败。");
	}
	/**
	 * 根据id进行删除
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@ApiOperation(value="根据id进行删除", response=CommResult.class)
	@PostMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult deleteScore(
			@ApiParam(value = "id",required = true)@RequestParam(value = "id")Long id){
		if(id == null){
			return CommResult.error("id不允许为空。");
		}

		boolean flag = scoreService.deleteScoreById(id);
		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("删除失败。");
	}
	/**
	 * 根据id查询数据
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@ApiOperation(value="根据id进行查询", response=CommResult.class)
	@ApiResponses({
		@ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
	})
	@PostMapping(value = "getById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult getScoreById(
			@ApiParam(value = "id",required = true)@RequestParam(value = "id")Long id){
		if(id == null){
			return CommResult.error("id不允许为空。");
		}

		ScoreVO vo = scoreService.getScoreById(id);
		return CommResult.ok(vo);
	}
	/**
	 * 查询所有数据
	 * @author wangpan
	 * create date 2019-09-05
	 */
	@ApiOperation(value="查询所有数据", response=CommResult.class)
	@ApiResponses({
		@ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
	})
	@PostMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult getAllScore(HttpServletRequest request,ScoreEntity entity){
		List<ScoreVO> list = scoreService.getAllScoreListByCondition(entity);
		return CommResult.ok(list);
	}
	/**
	 * 分页查询所有数据
	 * @author wangpan
	 * create date:2019-09-05
	 */
	@ApiOperation(value="分页查询所有数据", response=CommResult.class)
	@ApiResponses({
		@ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
	})
	@PostMapping(value = "getAllByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpResult<ScoreVO> getAllByPageScore(HttpServletRequest request,
			@ApiParam(value = "起始页",required = true)@RequestParam(value = "page",defaultValue="1")Integer page,
			@ApiParam(value = "每页条数",required = true)@RequestParam(value = "size",defaultValue="10")Integer size,ScoreEntity entity){
		HttpResult<ScoreVO> result = new HttpResult<ScoreVO>();
		PageInfo<ScoreVO> pages = scoreService.getPageScoreListByCondition(page,size,entity);
		result.setData(pages.getList());
		result.setiTotalRecords(pages.getTotal());
		return result;
	}

	/**
	 * 提交实验报告测试
	 * @author eden
	 * create date:2019-09-05
	 */
	/*
	@ApiOperation(value="提交实验报告测试", response=CommResult.class)
	@PostMapping(value = "submitTest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submitTest(HttpServletRequest request, ScoreEntity entity){
		//return CommResult.error(entity);
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		double score = 0;
		if(entity.getAnswer1()==5)score+=50;
		if(entity.getAnswer2()==8)score+=50;
		entity.setScore(score);

		scoreService.deleteScoreByStudentId(entity.getStudentId());

		boolean flag = scoreService.insertScore(entity);
		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");
	}
	*/

	/**
	 * 提交实验报告1-1-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告1-1-1",response=CommResult.class)
	@PostMapping(value="submit1-1-1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit1_1_1(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime11(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore1_1_1(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");

	}

	/**
	 * 提交实验报告1-2-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告1-2-1",response=CommResult.class)
	@PostMapping(value="submit1-2-1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit1_2_1(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime12(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore1_2_1(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");

	}

	/**
	 * 提交实验报告1-2-2
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告1-2-2",response=CommResult.class)
	@PostMapping(value="submit1-2-2",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit1_2_2(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime12(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore1_2_2(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");

	}

	/**
	 * 提交实验报告1-3-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告1-3-1",response=CommResult.class)
	@PostMapping(value="submit1-3-1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit1_3_1(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime13(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore1_3_1(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");

	}

	/**
	 * 提交实验报告1-3-2
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告1-3-2",response=CommResult.class)
	@PostMapping(value="submit1-3-2",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit1_3_2(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime13(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore1_3_2(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");

	}

	/**
	 * 提交实验报告2-1-1
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告2-1-1",response=CommResult.class)
	@PostMapping(value="submit2-1-1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit2_1_1(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime21(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore2_1_1(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");
	}

	/**
	 * 提交实验报告2-1-2
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告2-1-2",response=CommResult.class)
	@PostMapping(value="submit2-1-2",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit2_1_2(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime21(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore2_1_2(entity);

		if(flag){
			return CommResult.ok();
		}
		return CommResult.error("添加失败。");
	}

	/**
	 * 提交实验报告2-1-3
	 * @author eden
	 * create date:2020-03-26
	 */
	@ApiOperation(value="提交实验报告2-1-3",response=CommResult.class)
	@PostMapping(value="submit2-1-3",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult submit2_1_3(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		entity.setUpdateTime21(new Date());
		entity.setUpdateTime(new Date());
		entity.setStudentId(student.getId());
		//return CommResult.ok(entity);
		boolean flag=scoreService.insertScore2_1_3(entity);

		if(flag){

			return CommResult.ok();
		}
		return CommResult.error("添加失败。");
	}

	/**
	 * 根据student id查询数据
	 * @author eden
	 * create date:2019-09-05
	 */

	@ApiOperation(value="根据student id进行查询", response=CommResult.class)
	@ApiResponses({
			@ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
	})
	@PostMapping(value = "getByStudentId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommResult getScoreByStudentId(HttpServletRequest request, ScoreEntity entity){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		ScoreVO vo = scoreService.getScoreByStudentId(student.getId());
		return CommResult.ok(vo);
	}

	/**
	 * bvh文件上传
	 * @author eden
	 * create date:2019-09-05
	 */
	@ApiOperation(value="bvh文件上传", response=CommResult.class)
	@RequestMapping(value = "bvhFileUpLoad",method = RequestMethod.POST)
	public CommResult singleFileUpload(HttpServletRequest request,@RequestParam("file") MultipartFile file){
		StudentVO student = (StudentVO)redisService.get(request.getHeader("token"));
		//String fileName = file.getOriginalFilename();
		String fileName = student.getName()+".bvh";
		StringBuilder stringBuilder = new StringBuilder();
		//File fileDir = new File("/Users/eden/Desktop/");
		File fileDir = new File("/root/8079/");
		String path = fileDir.getAbsolutePath();
		try{
			file.transferTo(new File(path,fileName));
		}catch(Exception e){
			return CommResult.error(e);
		}

		return CommResult.ok();
	}

}