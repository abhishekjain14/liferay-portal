/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.shopping.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ShoppingItemPrice service. Represents a row in the &quot;ShoppingItemPrice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.shopping.model.impl.ShoppingItemPriceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.shopping.model.impl.ShoppingItemPriceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a shopping item price model instance should use the {@link ShoppingItemPrice} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPrice
 * @see com.liferay.portlet.shopping.model.impl.ShoppingItemPriceImpl
 * @see com.liferay.portlet.shopping.model.impl.ShoppingItemPriceModelImpl
 * @generated
 */
public interface ShoppingItemPriceModel extends BaseModel<ShoppingItemPrice> {
	/**
	 * Gets the primary key of this shopping item price.
	 *
	 * @return the primary key of this shopping item price
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this shopping item price
	 *
	 * @param pk the primary key of this shopping item price
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the item price id of this shopping item price.
	 *
	 * @return the item price id of this shopping item price
	 */
	public long getItemPriceId();

	/**
	 * Sets the item price id of this shopping item price.
	 *
	 * @param itemPriceId the item price id of this shopping item price
	 */
	public void setItemPriceId(long itemPriceId);

	/**
	 * Gets the item id of this shopping item price.
	 *
	 * @return the item id of this shopping item price
	 */
	public long getItemId();

	/**
	 * Sets the item id of this shopping item price.
	 *
	 * @param itemId the item id of this shopping item price
	 */
	public void setItemId(long itemId);

	/**
	 * Gets the min quantity of this shopping item price.
	 *
	 * @return the min quantity of this shopping item price
	 */
	public int getMinQuantity();

	/**
	 * Sets the min quantity of this shopping item price.
	 *
	 * @param minQuantity the min quantity of this shopping item price
	 */
	public void setMinQuantity(int minQuantity);

	/**
	 * Gets the max quantity of this shopping item price.
	 *
	 * @return the max quantity of this shopping item price
	 */
	public int getMaxQuantity();

	/**
	 * Sets the max quantity of this shopping item price.
	 *
	 * @param maxQuantity the max quantity of this shopping item price
	 */
	public void setMaxQuantity(int maxQuantity);

	/**
	 * Gets the price of this shopping item price.
	 *
	 * @return the price of this shopping item price
	 */
	public double getPrice();

	/**
	 * Sets the price of this shopping item price.
	 *
	 * @param price the price of this shopping item price
	 */
	public void setPrice(double price);

	/**
	 * Gets the discount of this shopping item price.
	 *
	 * @return the discount of this shopping item price
	 */
	public double getDiscount();

	/**
	 * Sets the discount of this shopping item price.
	 *
	 * @param discount the discount of this shopping item price
	 */
	public void setDiscount(double discount);

	/**
	 * Gets the taxable of this shopping item price.
	 *
	 * @return the taxable of this shopping item price
	 */
	public boolean getTaxable();

	/**
	 * Determines if this shopping item price is taxable.
	 *
	 * @return <code>true</code> if this shopping item price is taxable; <code>false</code> otherwise
	 */
	public boolean isTaxable();

	/**
	 * Sets whether this {$entity.humanName} is taxable.
	 *
	 * @param taxable the taxable of this shopping item price
	 */
	public void setTaxable(boolean taxable);

	/**
	 * Gets the shipping of this shopping item price.
	 *
	 * @return the shipping of this shopping item price
	 */
	public double getShipping();

	/**
	 * Sets the shipping of this shopping item price.
	 *
	 * @param shipping the shipping of this shopping item price
	 */
	public void setShipping(double shipping);

	/**
	 * Gets the use shipping formula of this shopping item price.
	 *
	 * @return the use shipping formula of this shopping item price
	 */
	public boolean getUseShippingFormula();

	/**
	 * Determines if this shopping item price is use shipping formula.
	 *
	 * @return <code>true</code> if this shopping item price is use shipping formula; <code>false</code> otherwise
	 */
	public boolean isUseShippingFormula();

	/**
	 * Sets whether this {$entity.humanName} is use shipping formula.
	 *
	 * @param useShippingFormula the use shipping formula of this shopping item price
	 */
	public void setUseShippingFormula(boolean useShippingFormula);

	/**
	 * Gets the status of this shopping item price.
	 *
	 * @return the status of this shopping item price
	 */
	public int getStatus();

	/**
	 * Sets the status of this shopping item price.
	 *
	 * @param status the status of this shopping item price
	 */
	public void setStatus(int status);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ShoppingItemPrice shoppingItemPrice);

	public int hashCode();

	public ShoppingItemPrice toEscapedModel();

	public String toString();

	public String toXmlString();
}