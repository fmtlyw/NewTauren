package com.lyw.lyw_provider.router

/**
 * 功能描述:全局路由路径
 * Created on 2021/4/14.
 * @author lyw
 */
class RouterPath {
    class Weather {
        companion object {
            const val PATH_WEATHER_HOME = "/weather/home"
        }
    }

    class Project {
        companion object {
            const val PATH_PROJECT_HOME = "/project/home"
        }
    }

    class Discover {
        companion object {
            const val PATH_DISCOVER_HOME = "/discover/home"
        }
    }

    class Public {
        companion object {
            const val PATH_PUBLIC_HOME = "/public/home"
        }
    }

    class Person {
        companion object {
            const val PATH_PERSON_HOME = "/person/home"
        }
    }

    class Video {
        companion object {
            const val PATH_VIDEO_HOME = "/video/home"
            const val PATH_VIDEO_WATCH = "/video/watch"
        }
    }
}