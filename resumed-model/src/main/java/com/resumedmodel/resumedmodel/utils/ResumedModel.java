package com.resumedmodel.resumedmodel.utils;

public interface ResumedModel<T> {
    T resume(ApiObjectMapper<T> apiObjectMapper);
}
