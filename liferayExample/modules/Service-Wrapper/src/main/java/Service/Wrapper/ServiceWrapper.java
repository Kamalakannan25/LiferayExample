package Service.Wrapper;

import com.liferay.portal.kernel.service.UserGroupLocalServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Suchismita
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class ServiceWrapper extends UserGroupLocalServiceWrapper {

	public ServiceWrapper() {
		super(null);
	}

//	public int getUsersCount() {
//		return super.getuser;
//	}
}