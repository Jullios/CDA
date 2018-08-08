package Rdr;

import java.util.LinkedList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pessoas.Paciente;
import pessoas.Components_p;

public class Patient {

	private Paciente paciente = new Paciente();
	
	
	public Paciente createPaciente(Document doc){
		
		NodeList RecordTarget = doc.getElementsByTagName("recordTarget");
		
		if(RecordTarget != null)
		{
			Node unico = RecordTarget.item(0);
			
			if(unico.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element)unico;
				
				NodeList rtFilhos = element.getChildNodes();
				
				int tamanho = rtFilhos.getLength();
				
				for(int i = 0; i < tamanho; i++)
				{
					Node filho = rtFilhos.item(i);
					if(filho.getNodeType() == Node.ELEMENT_NODE)
					{
						Element elementFilho = (Element)filho;
						
						switch(elementFilho.getTagName()){			//FILHOS DA TAG SECUNDARIA
							
						case "patientRole":
							NodeList prFilhos = elementFilho.getChildNodes();
							
							int prTamanho = prFilhos.getLength();
							
							for(int k = 0; k < prTamanho; k++)
							{
								Node prFilho = prFilhos.item(k);
								
								if(prFilho.getNodeType() == Node.ELEMENT_NODE)
								{
									Element prElement = (Element)prFilho;
									
									switch(prElement.getTagName()){
									case "id":				//SETAR ID
										String id = prElement.getAttribute("extension");
										paciente.setId(id);
										break;
										
									case "addr":
										String endereco = prElement.getTextContent();
										paciente.setEndereco(endereco);
										break;
										
									case "telecom":
										String numero = prElement.getAttribute("value");
										paciente.setNumero(numero);
										break;
										
									case "patient":
										NodeList patientFilhos = prElement.getChildNodes();
										
										int pfTamanho = patientFilhos.getLength();
										
										for(int j = 0; j < pfTamanho; j++)
										{
											Node patientFilho = patientFilhos.item(j);
											
											if(patientFilho.getNodeType() == Node.ELEMENT_NODE)
											{
												Element pfElement = (Element)patientFilho;
												
												switch(pfElement.getTagName()){
												
												case"name":
													
													NodeList name = pfElement.getChildNodes();
													for(int l = 0; l < name.getLength(); l++)
													{
														Node nomeFilho = name.item(l);
														
														if(nomeFilho.getNodeType() == Node.ELEMENT_NODE)
														{
															Element nfelement = (Element)nomeFilho;
															
															switch(nfelement.getTagName()){
															case "given":
																String nome = nfelement.getTextContent();
																paciente.setNome(nome);
																break;
																
															case "family":
																String sobrenome = nfelement.getTextContent();
																paciente.setSobrenome(sobrenome);
																break;
															}
														}
													}
													
													break;
												
												case"administrativeGenderCode":
													String genero = pfElement.getAttribute("code");
													paciente.setGenero(genero);
													break;
													
												}
												
												
											}
											
											
										}
										
										break;
									}
								}
								
								
							}
						
						
						}
						
					}
					
					
				}
			}
		}
		
		NodeList component = doc.getElementsByTagName("component");
		
		Components_p pacientComponent = null;
		
		LinkedList<String> itens = null; 
		
		int tamComponent = component.getLength();
		
		for(int i =0; i < tamComponent; i++)
		{
			
			Node componentAtual = component.item(i);
			
			if(componentAtual.getNodeType() == Node.ELEMENT_NODE)
			{
				Element componentElement = (Element)componentAtual;
				
				NodeList componentList = componentElement.getChildNodes();
				
				int tamCompList = componentList.getLength();
				
				for(int j = 0; j < tamCompList; j++)
				{
					pacientComponent = new Components_p();		//INICIEI COMPONENTS
					
					Node compItem = componentList.item(j);
					
					if(compItem.getNodeType() == Node.ELEMENT_NODE)
					{
						Element itemElement = (Element) compItem;
						
						switch(itemElement.getTagName()){
						case "section":
							NodeList sectionList = itemElement.getChildNodes();
							
							int tamSectionList = sectionList.getLength();
							
						//	pacientComponent = new Components_p();		//INICIEI COMPONENTS
							
							for(int l = 0; l < tamSectionList; l++)
							{
								Node sectionItem = sectionList.item(l);
								
								if(sectionItem.getNodeType() == Node.ELEMENT_NODE)
								{
									Element sectionElement = (Element)sectionItem;
									
									switch(sectionElement.getTagName()){
									
									case"title":
										pacientComponent.setTitle(sectionElement.getTextContent());
										break;
									case"text":
										NodeList sectionText = sectionElement.getChildNodes();

										int textLength = sectionText.getLength();
										for(int k = 0; k < textLength; k++)
										{
											Node textItem = sectionText.item(k);
											
											if(textItem.getNodeType() == Node.ELEMENT_NODE)
											{
												Element textElement = (Element) textItem;
												
												switch(textElement.getTagName()){
												case"list":
													NodeList listList = textElement.getChildNodes();
													
													itens = new LinkedList<String>();					//INICIEI LISTA DE ITENS
													
													int tamlistList = listList.getLength();
													
													for(int o = 0; o < tamlistList; o++)
													{
														Node listAtual = listList.item(o);
														
														if(listAtual.getNodeType() == Node.ELEMENT_NODE)
														{
															Element listAtualElement = (Element)listAtual;
															
															switch(listAtualElement.getTagName())
															{
																case"item":
																	NodeList itemList = listAtualElement.getChildNodes();
																	
																	int tamItemList = itemList.getLength();
																	
																	for(int f = 0; f < tamItemList; f++)
																	{
																		Node itemAtual = itemList.item(f);
																		
																		if(itemAtual.getNodeType() == Node.ELEMENT_NODE)
																		{
																			
																			Element itemAtualElement = (Element) itemAtual;
																			
																			switch(itemAtualElement.getTagName()){
																			
																			case"content":
																				//System.out.println();
																				itens.add(itemAtualElement.getTextContent());
																				break;
																			
																			}
																			
																		}
																		
																	}
																	//AQ
																	pacientComponent.setItens(itens);
																	break;
															
															
															}
															
														}
														
														
													}
													
													break;
												
												}
											}
											
										}
										
										break;
									
									
									}
									
								}
								
								
							}
							
							break;
						
						
						}
						
					}
					//AQ
					paciente.setComponents(pacientComponent);	
					
				}
				
			}
		}
		
		return paciente;
		
	}
	
}
