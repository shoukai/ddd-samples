/**
 * External Interface
 * 接口适配层、北向接口
 * 适配接口包括：
 * 1. REST Controller
 * 2. Dubbo Service：服务Provider
 * 3. Event Handler：事件处理器
 *
 * 技术要求：
 * 1. 本层次调用（包）： service、infrastructure、domain
 * 2. 其他层次（包），不能调用和引用 app （包）内容
 *
 * 功能描述：
 * 1. 消息验证；
 * 2. 错误处理；
 * 3. 监控处理；
 * 4. 认证和授权；
 */
package org.apframework.ddd.employee.app;