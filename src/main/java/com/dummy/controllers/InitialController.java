package com.dummy.controllers;

import com.dummy.beans.BaseBean;

/**
 * Created by Intel on 10/25/2015.
 */
public interface InitialController<T extends BaseBean> {

    public T getStudentDetail();

}
