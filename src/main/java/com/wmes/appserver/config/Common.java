package com.wmes.appserver.config;


import com.wmes.appserver.service.dto.ResultCodeDto;

import static com.wmes.appserver.config.Common.Message.*;
import static com.wmes.appserver.config.Common.StatusCode.*;

public class Common {
    public class StatusCode {
        public static final int STATUS_SUCCESS = 2000;
        public static final int STATUS_NO_ACCESS_RIGHTS = 4003;
        public static final int STATUS_NO_SESSION = 4010;
        public static final int STATUS_PARAMETER_ERROR = 4100;
        public static final int STATUS_MATCH_ERROR = 4101;
        public static final int STATUS_MIS_MATCH_FILE_ERROR = 4102;
        public static final int STATUS_EXIST_FILE_ERROR = 4103;
        public static final int STATUS_VALID_USERLOGINID = 4200;
        public static final int STATUS_INVALID_TOKEN = 4300;
        public static final int STATUS_INVALID_EVENT_TYPE = 4301;
        public static final int STATUS_CHECK_DEVICE_ID = 4302;
        public static final int STATUS_EXPIRATION_TOKEN = 4302;
        public static final int STATUS_NULL_TOKEN = 4303;
        public static final int STATUS_INVALID_SERVICEKEY = 4301;
        public static final int STATUS_APP_TYPE_MATCH = 4500;
        public static final int STATUS_USER_NULL = 4501;
        public static final int STATUS_PASSWORD_MIS_MATCH = 4503;
        public static final int STATUS_USER_MIS_MATCH = 4504;
        public static final int STATUS_PRE_PASSWORD_MIS_MATCH = 4505;
        public static final int STATUS_NOT_EXIST_EVENT = 5000;
        public static final int STATUS_NOT_EXIST_END_EVENT = 5001;
        public static final int STATUS_ALREADY_EXIST_END_EVENT = 5002;


    }

    public class Message {
        public static final String MESSAGE_SUCCESS = "성공";
        public static final String MESSAGE_NO_ACCESS_RIGHTS = "접근권한이 없습니다.";
        public static final String MESSAGE_NO_SESSION = "세션이 존재하지 않습니다.";
        public static final String MESSAGE_PARAMETER_ERROR = "필수 값이 입력되지 않았습니다.";
        public static final String MESSAGE_MATCH_ERROR = "값이 없습니다.";
        public static final String MESSAGE_MIS_MATCH_FILE_ERROR = "파일이 정보와 일치하지 않습니다.";
        public static final String MESSAGE_EXIST_FILE_ERROR = "이미 스냅샷 정보가 존재합니다.";
        public static final String MESSAGE_VALID_USERLOGINID = "동일한 아이디가 존재합니다.";
        public static final String MESSAGE_APP_TYPE_NULL = "어플리케이션 유형이 존재하지 않습니다.";
        public static final String MESSAGE_USER_NULL = "존재하지 않는 사용자 입니다.";
        public static final String MESSAGE_LOGIN_INFO_MISMATCH = "로그인 정보가 일치하지 않습니다.";
        public static final String MESSAGE_USER_INFO_MISMATCH = "유저 정보가 일치하지 않습니다.";
        public static final String MESSAGE_PRE_PASSWORD_MISMATCH = "기존 비밀번호가 일치하지 않습니다.";
        public static final String MESSAGE_INVALID_ID_TOKEN = "유효하지 않은 토큰입니다.";
        public static final String MESSAGE_INVALID_ID_EVENT_TYPE = "유효하지 않은 이벤트 타입입니다.";
        public static final String MESSAGE_CHECK_DEVICE_ID = "디바이스 아이디가 존재하지 않습니다.";
        public static final String MESSAGE_EXPIRATION_TOKEN = "Invalid or Expiration Token";
        public static final String MESSAGE_NULL_TOKEN = "Null Token";
        public static final String MESSAGE_INVALID_ID_SERVICEKEY = "유효하지 않은 서비스키입니다.";
        public static final String MESSAGE_NOT_EXIST_EVENT = "운행이벤트가 존재하지 않습니다.";
        public static final String MESSAGE_NOT_EXIST_END_EVENT = "운행종료 이벤트가 존재하지 않습니다.";
        public static final String MESSAGE_ALREADY_EXIST_END_EVENT = "운행종료 이벤트가 이미 존재합니다.";

    }

    public static ResultCodeDto returnNoAccessRightsError() {
        return new ResultCodeDto(STATUS_NO_ACCESS_RIGHTS, MESSAGE_NO_ACCESS_RIGHTS);
    }

    public static ResultCodeDto returnNoSessionError() {
        return new ResultCodeDto(STATUS_NO_SESSION, MESSAGE_NO_SESSION);
    }

    public static ResultCodeDto returnMatchError() {
        return new ResultCodeDto(STATUS_MATCH_ERROR, MESSAGE_MATCH_ERROR);
    }

    public static ResultCodeDto returnMisMatchFileError() {
        return new ResultCodeDto(STATUS_MIS_MATCH_FILE_ERROR, MESSAGE_MIS_MATCH_FILE_ERROR);
    }

    public static ResultCodeDto returnExistFileError() {
        return new ResultCodeDto(STATUS_EXIST_FILE_ERROR, MESSAGE_EXIST_FILE_ERROR);
    }

    public static ResultCodeDto returnParameterError() {
        return new ResultCodeDto(STATUS_APP_TYPE_MATCH, MESSAGE_PARAMETER_ERROR);
    }

    public static ResultCodeDto returnAppTypeNullError() {
        return new ResultCodeDto(STATUS_USER_NULL, MESSAGE_APP_TYPE_NULL);
    }

    public static ResultCodeDto returnUserNullError() {
        return new ResultCodeDto(STATUS_USER_NULL, MESSAGE_USER_NULL);
    }

    public static ResultCodeDto returnLoginInfoMisMatchError() {
        return new ResultCodeDto(STATUS_PASSWORD_MIS_MATCH, MESSAGE_LOGIN_INFO_MISMATCH);
    }

    public static ResultCodeDto returnUserInfoMisMatchError() {
        return new ResultCodeDto(STATUS_USER_MIS_MATCH, MESSAGE_USER_INFO_MISMATCH);
    }

    public static ResultCodeDto returnPrePasswordMisMatchError() {
        return new ResultCodeDto(STATUS_PRE_PASSWORD_MIS_MATCH, MESSAGE_PRE_PASSWORD_MISMATCH);
    }

    public static ResultCodeDto returnInvalidToken() {
        return new ResultCodeDto(STATUS_INVALID_TOKEN, MESSAGE_INVALID_ID_TOKEN);
    }

    public static ResultCodeDto returnInvalidEventType() {
        return new ResultCodeDto(STATUS_INVALID_EVENT_TYPE, MESSAGE_INVALID_ID_EVENT_TYPE);
    }

    public static ResultCodeDto returnCheckDeviceId() {
        return new ResultCodeDto(STATUS_CHECK_DEVICE_ID, MESSAGE_CHECK_DEVICE_ID);
    }

    public static ResultCodeDto returnExpirationToken() {
        return new ResultCodeDto(STATUS_EXPIRATION_TOKEN, MESSAGE_EXPIRATION_TOKEN);
    }

    public static ResultCodeDto returnNullToken() {
        return new ResultCodeDto(STATUS_NULL_TOKEN, MESSAGE_NULL_TOKEN);
    }

    public static ResultCodeDto returnInvalidServiceKey() {
        return new ResultCodeDto(STATUS_INVALID_SERVICEKEY, MESSAGE_INVALID_ID_SERVICEKEY);
    }

    public static ResultCodeDto returnValidUserLoginId() {
        return new ResultCodeDto(STATUS_VALID_USERLOGINID, MESSAGE_VALID_USERLOGINID);
    }

    public static ResultCodeDto returnNotExistEvent() {
        return new ResultCodeDto(STATUS_NOT_EXIST_EVENT, MESSAGE_NOT_EXIST_EVENT);
    }

    public static ResultCodeDto returnNotExistEndEvent() {
        return new ResultCodeDto(STATUS_NOT_EXIST_END_EVENT, MESSAGE_NOT_EXIST_END_EVENT);
    }

    public static ResultCodeDto returnAlreadyExistEndEvent() {
        return new ResultCodeDto(STATUS_ALREADY_EXIST_END_EVENT, MESSAGE_ALREADY_EXIST_END_EVENT);
    }


}
