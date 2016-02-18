package fi.arcusys.lr7.chuckportlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.service.UserLocalService;
import fi.arcusys.lr7.chuckapi.ChuckFacts;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=chuck-portlet Portlet",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.resource-bundle=content.Language"
    },
    service = Portlet.class
)
public class ChuckPortlet extends MVCPortlet {

    private UserLocalService _userLocalService;
    private ChuckFacts _chuckFacts;

    public UserLocalService getUserLocalService() {
        return _userLocalService;
    }

    @Reference
    public void setUserLocalService(UserLocalService _userLocalService) {
        this._userLocalService = _userLocalService;
    }

    public ChuckFacts getChuckFacts() {
        return _chuckFacts;
    }

    @Reference
    public void setChuckFacts(ChuckFacts _chuckFacts) {
        this._chuckFacts = _chuckFacts;
    }

    @Override
    public void doView(RenderRequest request, RenderResponse response)
            throws IOException, PortletException {

        request.setAttribute("USER_COUNT",
                getUserLocalService().getUsersCount());

        request.setAttribute("CHUCK_FACT",
                getChuckFacts().getRandomQuote());

        super.doView(request, response);
    }
}