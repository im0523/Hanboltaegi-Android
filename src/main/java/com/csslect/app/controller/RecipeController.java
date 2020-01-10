package com.csslect.app.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.csslect.app.command.ACommand;
import com.csslect.app.command.MaterialInsertCommand;
import com.csslect.app.command.MaterialSelectCommand;
import com.csslect.app.command.ProUpdateCommand;
import com.csslect.app.command.ProcedureInsertCommand;
import com.csslect.app.command.RecepeCommand;
import com.csslect.app.command.RecepeImageInsertCommand;
import com.csslect.app.command.RecepeInsertCommand;
import com.csslect.app.command.RecepeSelectCommand;
import com.csslect.app.command.matUpdateCommand;
import com.csslect.app.command.recDeleteCommand;
import com.csslect.app.command.recUpdateCommand;

@Controller
public class RecipeController {

	ACommand command;

	@RequestMapping(value = "/matSelect", method = { RequestMethod.GET, RequestMethod.POST })
	public String materialSelect(HttpServletRequest req, Model model) {
		System.out.println("materialSelect()");

		command = new MaterialSelectCommand();
		command.execute(model);

		return "matSelect";
	}

	@RequestMapping(value = "/recInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String recepeInsert(HttpServletRequest req, Model model) {
		System.out.println("recInsert()");
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String recipe_id = (String) req.getParameter("recipe_id");
		String userid = (String) req.getParameter("userid");
		String title = (String) req.getParameter("title");
		String subtitle = (String) req.getParameter("subtitle");
		String cat1 = (String) req.getParameter("cat1");
		String cat2 = (String) req.getParameter("cat2");
		String cat3 = (String) req.getParameter("cat3");
		String cat4 = (String) req.getParameter("cat4");
		String portion = (String) req.getParameter("portion");
		String time = (String) req.getParameter("time");
		String degree = (String) req.getParameter("degree");
		String material_id = (String) req.getParameter("material_id");
		String material_group = (String) req.getParameter("material_group");
		String imagepath = (String) req.getParameter("imagepath");
		String imagepath1 = (String) req.getParameter("imagepath1");
		String imagepath2 = (String) req.getParameter("imagepath2");
		String imagepath3 = (String) req.getParameter("imagepath3");
		String imagepath4 = (String) req.getParameter("imagepath4");
		System.out.println(recipe_id);
		System.out.println(title);
		System.out.println(imagepath);
		System.out.println(imagepath1);
		System.out.println(imagepath2);
		System.out.println(imagepath3);
		System.out.println(imagepath4);
		String cnt = (String) req.getParameter("cnt");
		String pnt = (String) req.getParameter("pnt");

		model.addAttribute("recipe_id", recipe_id);
		model.addAttribute("userid", userid);
		model.addAttribute("title", title);
		model.addAttribute("subtitle", subtitle);
		model.addAttribute("cat1", cat1);
		model.addAttribute("cat2", cat2);
		model.addAttribute("cat3", cat3);
		model.addAttribute("cat4", cat4);
		model.addAttribute("portion", portion);
		model.addAttribute("time", time);
		model.addAttribute("degree", degree);
		model.addAttribute("material_id", material_id);
		model.addAttribute("material_group", material_group);
		model.addAttribute("imagepath", imagepath);
		model.addAttribute("imagepath1", imagepath1);
		model.addAttribute("imagepath2", imagepath2);
		model.addAttribute("imagepath3", imagepath3);
		model.addAttribute("imagepath4", imagepath4);
		System.out.println("cnt : " + cnt);
		System.out.println("pnt : " + pnt);
		
		

		if (cnt.contentEquals("1")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("image");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
		}

		if (cnt.contentEquals("2")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("image");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("image1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}

		if (cnt.contentEquals("3")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("image");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("image1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("image2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}

		if (cnt.equals("4")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("image");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("image1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("image2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("image3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}

		if (cnt.contentEquals("5")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("image");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("image1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("image2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("image3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file4 = multi.getFile("image4");

			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());

					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}

		command = new RecepeInsertCommand();
		command.execute(model);

		System.out.println("matInsert()");

		String material_name0 = (String) req.getParameter("material_name0"),
				material_unit0 = (String) req.getParameter("material_unit0");
		String material_name1 = (String) req.getParameter("material_name1"),
				material_unit1 = (String) req.getParameter("material_unit1");
		String material_name2 = (String) req.getParameter("material_name2"),
				material_unit2 = (String) req.getParameter("material_unit2");
		String material_name3 = (String) req.getParameter("material_name3"),
				material_unit3 = (String) req.getParameter("material_unit3");
		String material_name4 = (String) req.getParameter("material_name4"),
				material_unit4 = (String) req.getParameter("material_unit4");
		String material_name5 = (String) req.getParameter("material_name5"),
				material_unit5 = (String) req.getParameter("material_unit5");
		String material_name6 = (String) req.getParameter("material_name6"),
				material_unit6 = (String) req.getParameter("material_unit6");
		String material_name7 = (String) req.getParameter("material_name7"),
				material_unit7 = (String) req.getParameter("material_unit7");
		String material_name8 = (String) req.getParameter("material_name8"),
				material_unit8 = (String) req.getParameter("material_unit8");
		String material_name9 = (String) req.getParameter("material_name9"),
				material_unit9 = (String) req.getParameter("material_unit9");
		model.addAttribute("recipe_id", recipe_id);
		model.addAttribute("material_name0", material_name0);
		model.addAttribute("material_unit0", material_unit0);
		model.addAttribute("material_name1", material_name1);
		model.addAttribute("material_unit1", material_unit1);
		model.addAttribute("material_name2", material_name2);
		model.addAttribute("material_unit2", material_unit2);
		model.addAttribute("material_name3", material_name3);
		model.addAttribute("material_unit3", material_unit3);
		model.addAttribute("material_name4", material_name4);
		model.addAttribute("material_unit4", material_unit4);
		model.addAttribute("material_name5", material_name5);
		model.addAttribute("material_unit5", material_unit5);
		model.addAttribute("material_name6", material_name6);
		model.addAttribute("material_unit6", material_unit6);
		model.addAttribute("material_name7", material_name7);
		model.addAttribute("material_unit7", material_unit7);
		model.addAttribute("material_name8", material_name8);
		model.addAttribute("material_unit8", material_unit8);
		model.addAttribute("material_name9", material_name9);
		model.addAttribute("material_unit9", material_unit9);

		command = new MaterialInsertCommand();
		command.execute(model);

		String text10 = (String) req.getParameter("text10");
		String text1 = (String) req.getParameter("text1");
		String text2 = (String) req.getParameter("text2");
		String text3 = (String) req.getParameter("text3");
		String text4 = (String) req.getParameter("text4");
		String text5 = (String) req.getParameter("text5");
		String text6 = (String) req.getParameter("text6");
		String text7 = (String) req.getParameter("text7");
		String text8 = (String) req.getParameter("text8");
		String text9 = (String) req.getParameter("text9");

		model.addAttribute("text10", text10);
		model.addAttribute("text1", text1);
		model.addAttribute("text2", text2);
		model.addAttribute("text3", text3);
		model.addAttribute("text4", text4);
		model.addAttribute("text5", text5);
		model.addAttribute("text6", text6);
		model.addAttribute("text7", text7);
		model.addAttribute("text8", text8);
		model.addAttribute("text9", text9);
		Date now = new Date();

		command = new ProcedureInsertCommand();
		command.execute(model);
		
		if(pnt.contentEquals("1")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");
	
			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);
	
				
				makeDir(req);
	
				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
	
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());
	
					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
	
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
	
				}
	
			}
		}
		
		if (pnt.contentEquals("2")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}
		
		if (pnt.contentEquals("3")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}
		
		if (pnt.contentEquals("4")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/recipe" + new SimpleDateFormat("yyyy/MM/dd").format(now) );

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("imageA3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

		}
		if (pnt.contentEquals("5")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("imageA3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file4 = multi.getFile("imageA4");

			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());

					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
		}
		if (pnt.contentEquals("6")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("imageA3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file4 = multi.getFile("imageA4");

			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());

					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file5 = multi.getFile("imageA5");

			if (file5 != null) {
				String fileName = file5.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file5.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file5.getSize());

					try {
						file5.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
		}
		if (pnt.contentEquals("7")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("imageA3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file4 = multi.getFile("imageA4");

			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());

					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file5 = multi.getFile("imageA5");

			if (file5 != null) {
				String fileName = file5.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file5.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file5.getSize());

					try {
						file5.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file6 = multi.getFile("imageA6");

			if (file6 != null) {
				String fileName = file6.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file6.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file6.getSize());

					try {
						file6.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
		}//7
	
		
		if (pnt.contentEquals("8")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("imageA3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file4 = multi.getFile("imageA4");

			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());

					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file5 = multi.getFile("imageA5");

			if (file5 != null) {
				String fileName = file5.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file5.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file5.getSize());

					try {
						file5.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file6 = multi.getFile("imageA6");

			if (file6 != null) {
				String fileName = file6.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file6.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file6.getSize());

					try {
						file6.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			MultipartFile file7 = multi.getFile("imageA7");

			if (file7 != null) {
				String fileName = file7.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file7.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file7.getSize());

					try {
						file7.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
		}//8
		
		if (pnt.contentEquals("9")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");

			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());

					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file1 = multi.getFile("imageA1");

			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());

					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file2 = multi.getFile("imageA2");

			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());

					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file3 = multi.getFile("imageA3");

			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());

					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}

			MultipartFile file4 = multi.getFile("imageA4");

			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());

					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file5 = multi.getFile("imageA5");

			if (file5 != null) {
				String fileName = file5.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file5.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file5.getSize());

					try {
						file5.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			
			MultipartFile file6 = multi.getFile("imageA6");

			if (file6 != null) {
				String fileName = file6.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file6.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file6.getSize());

					try {
						file6.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			MultipartFile file7 = multi.getFile("imageA7");

			if (file7 != null) {
				String fileName = file7.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file7.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file7.getSize());

					try {
						file7.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
			MultipartFile file8 = multi.getFile("imageA8");

			if (file8 != null) {
				String fileName = file8.getOriginalFilename();
				System.out.println(fileName);

				makeDir(req);

				if (file8.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");

					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file8.getSize());

					try {
						file8.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);

				}

			}
		}//9
		
		if (pnt.contentEquals("10")) {
			MultipartRequest multi = (MultipartRequest) req;
			MultipartFile file = multi.getFile("imageA0");
			
			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file.getSize());
					
					try {
						file.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file1 = multi.getFile("imageA1");
			
			if (file1 != null) {
				String fileName = file1.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file1.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file1.getSize());
					
					try {
						file1.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file2 = multi.getFile("imageA2");
			
			if (file2 != null) {
				String fileName = file2.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file2.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file2.getSize());
					
					try {
						file2.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file3 = multi.getFile("imageA3");
			
			if (file3 != null) {
				String fileName = file3.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file3.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file3.getSize());
					
					try {
						file3.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file4 = multi.getFile("imageA4");
			
			if (file4 != null) {
				String fileName = file4.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file4.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file4.getSize());
					
					try {
						file4.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file5 = multi.getFile("imageA5");
			
			if (file5 != null) {
				String fileName = file5.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file5.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file5.getSize());
					
					try {
						file5.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file6 = multi.getFile("imageA6");
			
			if (file6 != null) {
				String fileName = file6.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file6.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file6.getSize());
					
					try {
						file6.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			MultipartFile file7 = multi.getFile("imageA7");
			
			if (file7 != null) {
				String fileName = file7.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file7.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file7.getSize());
					
					try {
						file7.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			MultipartFile file8 = multi.getFile("imageA8");
			
			if (file8 != null) {
				String fileName = file8.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file8.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file8.getSize());
					
					try {
						file8.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
			MultipartFile file9 = multi.getFile("imageA9");
			
			if (file9 != null) {
				String fileName = file9.getOriginalFilename();
				System.out.println(fileName);
				
				makeDir(req);
				
				if (file9.getSize() > 0) {
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/");
					
					System.out.println(fileName + " : " + realImgPath);
					System.out.println("fileSize : " + file9.getSize());
					
					try {
						file9.transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					fileName = "FileFail.jpg";
					String realImgPath = req.getSession().getServletContext().getRealPath("/resources/" + fileName);
					System.out.println(fileName + " : " + realImgPath);
					
				}
				
			}
			
		}//end
		
		String imagepathA0 = (String) req.getParameter("imagepathA0");
		String imagepathA1 = (String) req.getParameter("imagepathA1");
		String imagepathA2 = (String) req.getParameter("imagepathA2");
		String imagepathA3 = (String) req.getParameter("imagepathA3");
		String imagepathA4 = (String) req.getParameter("imagepathA4");
		String imagepathA5 = (String) req.getParameter("imagepathA5");
		String imagepathA6 = (String) req.getParameter("imagepathA6");
		String imagepathA7 = (String) req.getParameter("imagepathA7");
		String imagepathA8 = (String) req.getParameter("imagepathA8");
		String imagepathA9 = (String) req.getParameter("imagepathA9");
		model.addAttribute("imagepathA0", imagepathA0);
		model.addAttribute("imagepathA1", imagepathA1);
		model.addAttribute("imagepathA2", imagepathA2);
		model.addAttribute("imagepathA3", imagepathA3);
		model.addAttribute("imagepathA4", imagepathA4);
		model.addAttribute("imagepathA5", imagepathA5);
		model.addAttribute("imagepathA6", imagepathA6);
		model.addAttribute("imagepathA7", imagepathA7);
		model.addAttribute("imagepathA8", imagepathA8);
		model.addAttribute("imagepathA9", imagepathA9);
		
		command = new RecepeImageInsertCommand();
		command.execute(model);

		return "recInsert";
	}

	@RequestMapping(value = "/rec", method = { RequestMethod.GET, RequestMethod.POST })
	public String rec(Model model, HttpServletRequest req) {

		System.out.println("rec()");

		String id = (String) req.getParameter("recipe_id");
		String title = (String) req.getParameter("title");
		String subtitle = (String) req.getParameter("subtitle");

		System.out.println(id);
		System.out.println(title);
		System.out.println(subtitle);

		model.addAttribute("recipe_id", id);
		model.addAttribute("title", title);
		model.addAttribute("subtitle", subtitle);

		command = new RecepeCommand();
		command.execute(model);

		return "rec";
	}

	@RequestMapping(value = "/recSelect", method = { RequestMethod.GET, RequestMethod.POST })
	public String anSelectMulti(HttpServletRequest req, Model model) {
		System.out.println("recSelect()");

		command = new RecepeSelectCommand();
		command.execute(model);

		return "recSelect";
	}

	public void makeDir(HttpServletRequest req) {
		File f = new File(req.getSession().getServletContext().getRealPath("/resources"));
		if (!f.isDirectory()) {
			f.mkdir();
		}
	}

	@RequestMapping(value = "/recUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public void recUpdate(HttpServletRequest req, Model model) {
		System.out.println("recUpdate()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String recipe_id = (String) req.getParameter("recipe_id");
		String title = (String) req.getParameter("title");
		String subtitle = (String) req.getParameter("subtitle");
		String cat1 = (String) req.getParameter("cat1");
		String cat2 = (String) req.getParameter("cat2");
		String cat3 = (String) req.getParameter("cat3");
		String cat4 = (String) req.getParameter("cat4");
		String portion = (String) req.getParameter("portion");
		String time = (String) req.getParameter("time");
		String degree = (String) req.getParameter("degree");
		String material_id = (String) req.getParameter("material_id");
		String material_group = (String) req.getParameter("material_group");
		String imagepath = (String) req.getParameter("imagepath");
		String imagepath1 = (String) req.getParameter("imagepath1");
		String imagepath2 = (String) req.getParameter("imagepath2");
		String imagepath3 = (String) req.getParameter("imagepath3");
		String imagepath4 = (String) req.getParameter("imagepath4");
		System.out.println(recipe_id);
		System.out.println(title);
		System.out.println(material_id);
		System.out.println(material_group);

		model.addAttribute("recipe_id", recipe_id);
		model.addAttribute("title", title);
		model.addAttribute("subtitle", subtitle);
		model.addAttribute("cat1", cat1);
		model.addAttribute("cat2", cat2);
		model.addAttribute("cat3", cat3);
		model.addAttribute("cat4", cat4);
		model.addAttribute("portion", portion);
		model.addAttribute("time", time);
		model.addAttribute("degree", degree);
		model.addAttribute("material_id", material_id);
		model.addAttribute("material_group", material_group);
		model.addAttribute("imagepath", imagepath);
		model.addAttribute("imagepath1", imagepath1);
		model.addAttribute("imagepath2", imagepath2);
		model.addAttribute("imagepath3", imagepath3);
		model.addAttribute("imagepath4", imagepath4);

		command = new recUpdateCommand();
		command.execute(model);

		System.out.println("matUpdate()");

		String material_name0 = (String) req.getParameter("material_name0"),
				material_unit0 = (String) req.getParameter("material_unit0");
		String material_name1 = (String) req.getParameter("material_name1"),
				material_unit1 = (String) req.getParameter("material_unit1");
		String material_name2 = (String) req.getParameter("material_name2"),
				material_unit2 = (String) req.getParameter("material_unit2");
		String material_name3 = (String) req.getParameter("material_name3"),
				material_unit3 = (String) req.getParameter("material_unit3");
		String material_name4 = (String) req.getParameter("material_name4"),
				material_unit4 = (String) req.getParameter("material_unit4");
		String material_name5 = (String) req.getParameter("material_name5"),
				material_unit5 = (String) req.getParameter("material_unit5");
		String material_name6 = (String) req.getParameter("material_name6"),
				material_unit6 = (String) req.getParameter("material_unit6");
		String material_name7 = (String) req.getParameter("material_name7"),
				material_unit7 = (String) req.getParameter("material_unit7");
		String material_name8 = (String) req.getParameter("material_name8"),
				material_unit8 = (String) req.getParameter("material_unit8");
		String material_name9 = (String) req.getParameter("material_name9"),
				material_unit9 = (String) req.getParameter("material_unit9");
		model.addAttribute("recipe_id", recipe_id);
		model.addAttribute("material_name0", material_name0);
		model.addAttribute("material_unit0", material_unit0);
		model.addAttribute("material_name1", material_name1);
		model.addAttribute("material_unit1", material_unit1);
		model.addAttribute("material_name2", material_name2);
		model.addAttribute("material_unit2", material_unit2);
		model.addAttribute("material_name3", material_name3);
		model.addAttribute("material_unit3", material_unit3);
		model.addAttribute("material_name4", material_name4);
		model.addAttribute("material_unit4", material_unit4);
		model.addAttribute("material_name5", material_name5);
		model.addAttribute("material_unit5", material_unit5);
		model.addAttribute("material_name6", material_name6);
		model.addAttribute("material_unit6", material_unit6);
		model.addAttribute("material_name7", material_name7);
		model.addAttribute("material_unit7", material_unit7);
		model.addAttribute("material_name8", material_name8);
		model.addAttribute("material_unit8", material_unit8);
		model.addAttribute("material_name9", material_name9);
		model.addAttribute("material_unit9", material_unit9);

		command = new matUpdateCommand();
		command.execute(model);

		System.out.println("ProUpdate()");

		String text0 = (String) req.getParameter("text0");
		String text1 = (String) req.getParameter("text1");
		String text2 = (String) req.getParameter("text2");
		String text3 = (String) req.getParameter("text3");
		String text4 = (String) req.getParameter("text4");
		String text5 = (String) req.getParameter("text5");
		String text6 = (String) req.getParameter("text6");
		String text7 = (String) req.getParameter("text7");
		String text8 = (String) req.getParameter("text8");
		String text9 = (String) req.getParameter("text9");

		model.addAttribute("text0", text0);
		model.addAttribute("text1", text1);
		model.addAttribute("text2", text2);
		model.addAttribute("text3", text3);
		model.addAttribute("text4", text4);
		model.addAttribute("text5", text5);
		model.addAttribute("text6", text6);
		model.addAttribute("text7", text7);
		model.addAttribute("text8", text8);
		model.addAttribute("text9", text9);

		command = new ProUpdateCommand();
		command.execute(model);

	}

	@RequestMapping(value = "/recDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public void recDelete(HttpServletRequest req, Model model) {
		System.out.println("recDelete()");

		model.addAttribute("recipe_id", req.getParameter("recipe_id"));

		System.out.println((String) req.getParameter("recipe_id"));

		command = new recDeleteCommand();
		command.execute(model);

	}

}
