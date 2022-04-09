package com.example.fleamarket.exception.handler;

import com.example.fleamarket.exception.ControllerException;
import com.example.fleamarket.exception.ServiceException;
import com.example.fleamarket.response.ResultVo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//全局异常处理类
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { ControllerException.class, ServiceException.class })
	public ResponseEntity<ResultVo> controllerExceptionHandler(Exception e) {
		log.info("ControllerException/ServiceException:" + e.getMessage());
		return new ResponseEntity<ResultVo>(new ResultVo(400, e.getMessage(), null),
				HttpStatus.BAD_REQUEST);
	}
}
