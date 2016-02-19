package fi.arcusys.lr7.chuckportlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "fi.arcusys.lr7.chuckportlet.ChuckConf")
public interface ChuckConf {
    @Meta.AD(
            deflt = "Chuck rules!",
            required = false
    )
    String title();
}