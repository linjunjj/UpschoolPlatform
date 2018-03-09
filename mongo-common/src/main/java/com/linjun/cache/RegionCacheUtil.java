package com.linjun.cache;

import com.linjun.dao.SysRegionDao;
import com.linjun.entity.SysRegionEntity;
import com.linjun.utils.SpringContextUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegionCacheUtil implements InitializingBean {
    public  static List<SysRegionEntity>  sysRegionEntityList;
    @Override
    public void afterPropertiesSet() throws Exception {
       init();
    }

    public  static  void  init(){
        SysRegionDao regionDao = SpringContextUtils.getBean(SysRegionDao.class);
        if (null != regionDao) {
            sysRegionEntityList = regionDao.queryList(new HashMap<String, Object>());
        }
    }

//    获取所有国家
    public  static  List getAllCountry(){
        List<SysRegionEntity> resultobj=new ArrayList<>();
        if (null!=sysRegionEntityList){
            for (SysRegionEntity areao: sysRegionEntityList) {
                if (areao.getType()==0){
                    resultobj.add(areao);
                }
            }
        }
        return  resultobj;
    }
//获取所有的省；
    public  static  List getAllPrivince(){
        List<SysRegionEntity> resultobj=new ArrayList<>();
        if (sysRegionEntityList!=null){
            for (SysRegionEntity area:
                sysRegionEntityList ) {
                if (area.getType()==1)
                    resultobj.add(area);
            }
        }
        return  resultobj;
    }
//获取所有的城市
    public  static  List getAllCity(){
        List<SysRegionEntity> resultobj=new ArrayList<>();
        if (sysRegionEntityList!=null){
            for (SysRegionEntity area:
                 sysRegionEntityList) {
                if (area.getType()==2)
                    resultobj.add(area);
            }
        }
        return  resultobj;
    }
//  根据国家获取所有的省份
    public  static  List getAllProviceByParentId(Integer areaId){
        List<SysRegionEntity> resultobj=new ArrayList<>();
        if (areaId==null){
            return  resultobj;
        }
        if (sysRegionEntityList!=null){
            for (SysRegionEntity area:
                    sysRegionEntityList) {
                if (area.getParentId()!=null&& area.getType().equals(1) && areaId.equals(area.getParentId()))
                    resultobj.add(area);
            }
        }
        return  resultobj;
    }
    /**
     * 获取地市
     *
     * @return
     */
    public static List getChildrenCity(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(2) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取地市
     *
     * @return
     */
    public static List getChildrenCity(String proviceName) {
        List<SysRegionEntity> resultObj = new ArrayList();
        if (null == proviceName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(2) && proviceName.equals(areaVo.getParentName())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenDistrict(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(3) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenDistrict(String provinceName, String cityName) {
        List<SysRegionEntity> resultObj = new ArrayList();
        if (null == provinceName || null == cityName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(3)
                        && cityName.equals(areaVo.getParentName())
                        && null != getAreaByAreaId(areaVo.getParentId())
                        && provinceName.equals(getAreaByAreaId(areaVo.getParentId()).getParentName())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }


    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenByParentId(Integer parentId) {
        List<SysRegionEntity> resultObj = new ArrayList();
        if (null == parentId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && parentId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区域名称
     *
     * @return
     */
    public static String getAreaNameByAreaId(Integer areaId) {
        if (null == areaId) {
            return "";
        }
        String resultObj = areaId.toString();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getId().equals(areaId)) {
                    resultObj = areaVo.getName();
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static SysRegionEntity getAreaByAreaId(Integer areaId) {
        SysRegionEntity resultObj = null;
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getId().equals(areaId)) {
                    resultObj = areaVo;
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getProvinceIdByName(String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 1 && areaVo.getName().equals(areaName)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getCityIdByName(Integer provinceId, String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 2 && areaVo.getName().equals(areaName)
                        && areaVo.getParentId().equals(provinceId)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }


    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getDistrictIdByName(Integer provinceId, Integer cityId, String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 3 && areaVo.getName().equals(areaName)
                        && areaVo.getParentId().equals(cityId)
                        && null != getAreaByAreaId(areaVo.getParentId())
                        && null != getAreaByAreaId(areaVo.getParentId()).getParentId()
                        && getAreaByAreaId(areaVo.getParentId()).getParentId().equals(provinceId)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }


}
