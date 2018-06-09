package com.haod.www.chatroot.base;

import java.util.List;

public class Translation {
    /**
     * code : 308000
     * text : 亲，已帮您找到菜谱信息
     * list : [{"name":"辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/81db76d6888511e6b87c0242ac110003_640w_640h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分7.9 3274人下厨","detailurl":"http://m.xiachufang.com/recipe/100379142/?ref=tuling"},{"name":"湖南辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/684ad326890f11e6b87c0242ac110003_640w_520h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分8.0 369人下厨","detailurl":"http://m.xiachufang.com/recipe/100493684/?ref=tuling"},{"name":"农家小炒肉【记忆中勾魂的油汤】","icon":"http://s2.cdn.xiachufang.com/51f0dbf08a0b11e6a9a10242ac110002_5184w_3456h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分8.3 1821人下厨","detailurl":"http://m.xiachufang.com/recipe/100628259/?ref=tuling"},{"name":"家常辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/4d8e5612896311e6a9a10242ac110002_1000w_663h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分7.8 255人下厨","detailurl":"http://m.xiachufang.com/recipe/100549394/?ref=tuling"},{"name":"辣椒炒肉","icon":"http://s1.cdn.xiachufang.com/21f254fc8bb811e6b87c0242ac110003_1350w_1800h.jpg@2o_50sh_1pr_1l_280w_190h_1c_1e_90q_1wh","info":"评分8.1 163人下厨","detailurl":"http://m.xiachufang.com/recipe/102052920/?ref=tuling"},{"name":"辣椒炒肉（经典湘菜版）","icon":"http://s1.cdn.xiachufang.com/8973f078fd5411e6947d0242ac110002_1151w_1280h.jpg@2o_50sh_1pr_1l_280w_190h_1c_1e_90q_1wh","info":"评分8.0 168人下厨","detailurl":"http://m.xiachufang.com/recipe/1049496/?ref=tuling"},{"name":"农家小炒肉or辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/9b8d86a4878211e6a9a10242ac110002_600w_800h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分8.1 508人下厨","detailurl":"http://m.xiachufang.com/recipe/1068757/?ref=tuling"},{"name":"超级正宗辣椒炒肉ʕ \u2022ᴥ\u2022ʔ","icon":"http://s2.cdn.xiachufang.com/9a946a76891011e6b87c0242ac110003_638w_636h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分7.9 26人下厨","detailurl":"http://m.xiachufang.com/recipe/100494571/?ref=tuling"},{"name":"辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/9d981104ab2111e6bc9d0242ac110002_1280w_828h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分8.1 47人下厨","detailurl":"http://m.xiachufang.com/recipe/102147561/?ref=tuling"},{"name":"辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/7a25759c88e711e6b87c0242ac110003_1239w_1059h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分7.5 44人下厨","detailurl":"http://m.xiachufang.com/recipe/100460939/?ref=tuling"},{"name":"辣椒炒鸡","icon":"http://s2.cdn.xiachufang.com/84a0915889c511e6a9a10242ac110002_800w_600h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分8.4 1249人下厨","detailurl":"http://m.xiachufang.com/recipe/100591673/?ref=tuling"},{"name":"酿辣椒","icon":"http://s2.cdn.xiachufang.com/09a9d39688c711e6a9a10242ac110002_476w_476h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分7.8 404人下厨","detailurl":"http://m.xiachufang.com/recipe/100429594/?ref=tuling"},{"name":"辣椒炒肉肉","icon":"http://s2.cdn.xiachufang.com/6d758a18873d11e6b87c0242ac110003_670w_670h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分27人下厨","detailurl":"http://m.xiachufang.com/recipe/1003213/?ref=tuling"},{"name":"湘菜辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/cad3f4f088c911e6b87c0242ac110003_448w_245h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分12人下厨","detailurl":"http://m.xiachufang.com/recipe/100432331/?ref=tuling"},{"name":"豆豉辣椒炒肉","icon":"http://s2.cdn.xiachufang.com/568eef7e875b11e6a9a10242ac110002_3872w_2592h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90","info":"评分7.0 171人下厨","detailurl":"http://m.xiachufang.com/recipe/1041225/?ref=tuling"}]
     */

    private int code;
    private String text;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * name : 辣椒炒肉
         * icon : http://s2.cdn.xiachufang.com/81db76d6888511e6b87c0242ac110003_640w_640h.jpg?imageView2/1/w/280/h/190/interlace/1/q/90
         * info : 评分7.9 3274人下厨
         * detailurl : http://m.xiachufang.com/recipe/100379142/?ref=tuling
         */

        private String name;
        private String icon;
        private String info;
        private String detailurl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getDetailurl() {
            return detailurl;
        }

        public void setDetailurl(String detailurl) {
            this.detailurl = detailurl;
        }
    }

}
