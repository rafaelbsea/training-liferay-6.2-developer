package com.liferay.training.demo;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class DemoPortlet
 * 
 * @author Rafael Barros
 */
public class DemoPortlet extends GenericPortlet {

	public void init() {
		editJSP = getInitParameter("edit-template");
		helpJSP = getInitParameter("help-template");
		viewJSP = getInitParameter("view-template");

		// Initalizes the portlet
		System.out
				.println("[ init() phase of the life cycle of the portlet ]");
	}

	public void destroy() {
		
		// Releases the portlet object so it is eligible for garbage collection
		System.out
				.println("[ destroy() phase of the life cycle of the portlet ]");
		
		super.destroy();
	}

	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		// Renders the content
		System.out
				.println("[ render() phase of the life cycle of the portlet ]");

		super.render(renderRequest, renderResponse);
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		// Called when the user performs an action
		System.out
				.println("[ processAction() action phase of the life cycle of the portlet ]");

	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException,
			IOException {

		// Called when a ResourceURL is requested
		System.out
				.println("[ serveResource() resource serving phase of the life cycle of the portlet ]");
		resourceResponse.setContentType(ContentTypes.TEXT_XML_UTF8);
		resourceResponse.getWriter().write("Resource served successfuly!");

	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		//System.out.println("Inside doEdit()");
		include(editJSP, renderRequest, renderResponse);
	}

	public void doHelp(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		//System.out.println("Inside doHelp()");
		include(helpJSP, renderRequest, renderResponse);
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		//System.out.println("Inside doView()");
		include(viewJSP, renderRequest, renderResponse);
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(DemoPortlet.class);

}
