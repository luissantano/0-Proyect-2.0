package com.iesemilidarder.spring.core;

/**
 * proyecto-cero3
 * com.iesemilidarder.spring.core
 * Create by winadmin in 2/2/2018.
 * Description:
 */
    public class Greeting {
        private final long id;
        private final String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }


