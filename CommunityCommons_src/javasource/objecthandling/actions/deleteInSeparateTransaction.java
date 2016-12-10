// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objecthandling.actions;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.ISession;

/**
 * This function deletes a list of object in a seperate context and transaction, making sure it gets deleted from the database (regarding which exception happens after invocation).
 */
public class deleteInSeparateTransaction extends CustomJavaAction<Boolean>
{
	private java.util.List<IMendixObject> objectList;

	public deleteInSeparateTransaction(IContext context, java.util.List<IMendixObject> objectList)
	{
		super(context);
		this.objectList = objectList;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		ISession session = getContext().getSession();
		IContext newContext = session.createContext();
		Core.delete(newContext, objectList);
		newContext.endTransaction();
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "deleteInSeparateTransaction";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
